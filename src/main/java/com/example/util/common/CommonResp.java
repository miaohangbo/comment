package com.example.util.common;

import java.io.Serializable;

/**
 * 公共返回类
 * 可以在api层组装，也可以在service层组装
 * @author mcl
 * @param <T>
 *
 */
public class CommonResp<T> implements Serializable {

    private String code;//返回码
    private String message;//消息描述
    private T data;//数据体（pager）
    private Pager page;
    
    public CommonResp() {
    }
    
    /**
     * 初始化
     * @return
     */
    public static CommonResp getInstance() {
        CommonResp commonResp = new CommonResp();
        commonResp.code = BaseRespCodeEnum.SUCCESS;
        commonResp.message = "";
        return commonResp;
    }
    
    /**
     * 初始化错误
     * @param message 错误消息
     * @return
     */
    public static CommonResp getErrorInstance(String message) {
        CommonResp commonResp = new CommonResp();
        commonResp.code = BaseRespCodeEnum.EXEC_ERROR;
        commonResp.message = message;
        return commonResp;
    }
    
    /**
     * 初始化
     * @param code 返回码
     * @param message 消息
     * @return
     */
    public static CommonResp getInstance(String code, String message) {
        CommonResp commonResp = new CommonResp();
        commonResp.code = code;
        commonResp.message = message;
        return commonResp;
    }
    
    /**
     * 初始化
     * @param code 返回码
     * @param message 消息
     * @param data 数据
     * @return
     */
    public static CommonResp getInstance(String code, String message, Object data) {
        CommonResp commonResp = new CommonResp();
        commonResp.code = code;
        commonResp.message = message;
        commonResp.data = data;
        return commonResp;
    }
    
    /**
     * 初始化成功
     * @param data 数据
     * @return
     */
    public static CommonResp getInstance(Object data) {
        CommonResp commonResp = new CommonResp();
        commonResp.code = BaseRespCodeEnum.SUCCESS;
        commonResp.message = "";
        commonResp.data = data;
        return commonResp;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Pager getPage() {
        return page;
    }

    public void setPage(Pager page) {
        this.page = page;
    }


    public static CommonResp getInstance(String code, String message, Object data,Pager pager) {
        CommonResp commonResp = new CommonResp();
        commonResp.code = code;
        commonResp.message = message;
        commonResp.data = data;
        commonResp.page = pager;
        return commonResp;
    }
}
