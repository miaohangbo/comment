package com.example.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


import com.example.annotation.Guest;
import com.example.util.common.*;
import com.lx.user.common.annotation.Login;
import com.lx.user.common.constants.RequestMethodType;
import com.lx.user.common.entity.ResponseResult;
import com.lx.user.common.enums.CodeEnum;
import com.lx.user.common.interfaces.BaseParamCheck;
import com.lx.user.common.utils.JsonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @ClassName: ApiAspect
 * @Description: api切面
 * @author guokp
 * @date 2017年3月20日 上午9:46:25
 */
@Aspect
@Component
public class ApiAspect {
    
    private static Logger logger = LoggerFactory.getLogger(ApiAspect.class);

    //@SuppressWarnings({ "unused", "rawtypes" })
    @Around(value = "@annotation(com.example.annotation.Api)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Thread.currentThread().setName(org.apache.commons.lang3.StringUtils.remove(UUID.randomUUID().toString(), '-'));
        HttpServletRequest request = (HttpServletRequest) ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String url = getFullURL(request);
        logger.debug("url:" + url);
        String methodName = pjp.getSignature().getName();
        logger.debug("methodName：" + methodName);
        String targetName = pjp.getTarget().getClass().getName();
        logger.debug("controller:" + targetName);
        
        String reqBody = getJsonData(request);
        
        logger.info(url + ", 新API请求参数：" + reqBody);
        Class<?>[] parameterTypes = ((MethodSignature) pjp.getSignature())
                .getParameterTypes();
        Object[] args = pjp.getArgs();
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        
        ReqHeader header = null;
        Pager pager = null;
        if (!request.getMethod().equalsIgnoreCase(RequestMethodType.POST)) {
            BaseReqVo baseParam = (BaseReqVo) args[0];
            // 判断此接口需不需要登录
            Long userId = baseParam.getUserid();
            Login login = method.getAnnotation(Login.class);
            if (login != null) { // 此接口需要登陆的话，则判断是否登录
                if (userId == null || userId<= 0) {
                    throw new RuntimeException("userId格式不正确");
                }
                header = new ReqHeader();
                header.setUserid(userId);
                header.setToken(baseParam.getToken());
                baseParam.setHeader(header);
            }
            return wrapResult(pjp, args, methodName, RequestMethodType.GET);
        } else {
            JSONObject jsonObject = JSON.parseObject(reqBody);
            if (!jsonObject.containsKey(RequestParam.HEADER)) {
                throw new RuntimeException("没有请求头！");
            }
            header = JsonUtil.getBean(jsonObject.getString(RequestParam.HEADER), ReqHeader.class);
            if (jsonObject.getJSONObject(RequestParam.PAGER)!=null) {
                pager = JsonUtil.getBean(jsonObject.getString(RequestParam.PAGER), Pager.class);
            }
            
            // 判断此接口需不需要登录
            String token = header.getToken();
            System.out.println("token"+token);
            Login login = method.getAnnotation(Login.class);
            Guest guest = method.getAnnotation(Guest.class);
            String usereId = "0";
            if (login != null && null == guest) { // 此接口需要登陆的话，则判断是否登录
            	
                if (StringUtils.isBlank(token)) {
                    throw new RuntimeException("token格式不正确");
                }
                usereId = FrameUtilV2.getUserid(token);
             /*   UserAccount ua = userService.selectByPrimaryKey(Long.valueOf(usereId));
                if(ua.getStatus()== Enums.STATUS_DELETE){
                    return CommonResp.getInstance(ResultCodeFactory.REQUEST_USER_DELETE,userService.getUserForbiddenContent(Long.valueOf(usereId)));
                }*/
                System.out.println("usereId:"+usereId);
                if(StringUtils.isBlank(usereId)){
                    throw new RuntimeException("token格式不正确");
                }
                header.setUserid(Long.valueOf(usereId));
            }
            
            if (null != args && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    Object arg = args[i];
                    Class paramClass = parameterTypes[i];
                    if (arg instanceof BaseReqVo) {
                        BaseReqVo baseParam = (BaseReqVo) arg;
                        if (reqBody != null) {
                            if (jsonObject.getString(RequestParam.BODY) != null) {
                                baseParam = JsonUtil.getBean(jsonObject.getString(RequestParam.BODY), baseParam.getClass());
                            }
                            if(null==baseParam){
                            	baseParam= baseParam.getClass().newInstance();
                            }
                            baseParam.setHeader(header);
                            baseParam.setPager(pager);
                            baseParam.setUserid(Long.valueOf(usereId));
                            baseParam.setToken(header.getToken());
                        }
                        args[i] = baseParam;
                        break;
                    }
                }
            }
            return wrapResult(pjp, args, methodName, RequestMethodType.POST);
        }
    }

    /**
     * @Description:
     * @author guokp
     * @param pjp 切面
     * @param args 参数
     * @param method 当前方法
     * @param methodType 请求类型
     * @return ResponseResult
     * @throws Throwable
     */
    //@Pointcut("execution(* com.example.comment.controller.*.**(..))")
    private Object wrapResult(ProceedingJoinPoint pjp, Object[] args,
            String method, String methodType) throws Throwable {
        
        Object obj = null;
        ResponseResult result = null;
        long start = System.currentTimeMillis();
        if (null == args || args.length == 0) {
            obj = pjp.proceed();
            if(obj instanceof ResponseResult) {
                result = (ResponseResult) obj;
            }else{
                return obj;
            }
        } else {
            checkParam(args);
            obj = pjp.proceed(args);
            if(obj instanceof ResponseResult) {
                result = (ResponseResult) obj;
            }else{
                return obj;
            }
//            result = (ResponseResult) pjp.proceed(args);
        }
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setMessage(CodeEnum.SUCCESS.getValue());
        long end = System.currentTimeMillis();
        logger.info((end - start) + "毫秒响应新API数据：" + JsonUtil.toJSONString(result));
        return result;
    }

    /**
     * @Description: 获取接口请求完整路径，包括参数
     * @author guokp
     * @param request
     *            HttpServletRequest
     * @return 返回完整请求路径
     */
    private String getFullURL(HttpServletRequest request) {
        StringBuffer url = request.getRequestURL();
        if (request.getQueryString() != null) {
            url.append("?");
            url.append(request.getQueryString());
        }
        return url.toString();
    }

    /**
     * @Description: 在方法调用执行前，进行参数校验
     * @author guokp
     * @param requestParams 参数
     */
    private void checkParam(Object[] requestParams) {
        for (Object requestParam : requestParams) {
            if (requestParam instanceof BaseParamCheck) {
                BaseParamCheck param = (BaseParamCheck) requestParam;
                param.checkParam();
            }
        }
    }
    
    /**
    * @Description: 通过HttpServletRequest获取请求体
    * @author guokp 
    * @param request
     */

    private String getJsonData(HttpServletRequest request) {
        ServletInputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder(); 
        if(null!=inputStream){
            try {
                br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }  
            String line = null;  
            try {
                while((line = br.readLine())!=null){  
                    sb.append(line);  
                }
            } catch (IOException e) {
                e.printStackTrace();
            }  finally{
                if(null!=br){
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sb.toString();
    }
}
