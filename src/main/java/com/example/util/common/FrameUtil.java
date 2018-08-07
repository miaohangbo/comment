package com.example.util.common;


import com.alibaba.druid.util.StringUtils;
import com.example.util.spring.SpringBeanUtil;
import com.lx.user.api.service.TokenService;
import com.lx.user.common.entity.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.StringTokenizer;

//import java.text.SimpleDateFormat;

/**
 * 《检测》
 * 
 * @author 万凌志
 * @version $Id: Checking.java,v 1.11 2011/09/21 07:23:37 wanlei Exp $
 */
public class FrameUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(FrameUtil.class);
	private static TokenService tokenService = SpringBeanUtil.getBean("tokenService");

	/**
	 * 判断字符串为null或者为""
	 *
	 * @param value
	 *            要判断的字符串
	 * @return 是否为null或者为""
	 */
	public static boolean isNullorBlank(Object value) {
		return null == value || isNullorBlank(value.toString());
	}

	/**
	 * 判断字符串为null或者为""
	 *
	 * @param value
	 *            要判断的字符串
	 * @return 是否为null或者为""
	 */
	public static boolean isNullorBlank(String value) {
		return null == value || "".equals(value.trim());
	}

	/**
	 * 判断是否是数字
	 *
	 * @param num
	 * @return
	 */
	public static boolean isNumeric(Object num) {
		if (num == null || num.toString().length() <= 0) {
			return false;
		}
		String str = num.toString();
		if (str.length() <= 0) {
			return false;
		}
		if (str.matches("\\d{1,}")) {
			return true;
		}
		if (str.matches("^((-\\d+)|(0+))$")) {
			return true;
		}
		return false;
	}

	// 加密uid
	/*public static String encryptionuid(Long userid)
			throws UnsupportedEncodingException {
		if (userid == null) {
			return "";
		}
		String str = encryption(userid + "|" + new Date().getTime(), SysConst.USERID_KEY);
		if (str != null) {
			if (str.indexOf("+") >= 0) {
				str = str.replaceAll("\\+", "*");
			}
			if (str.indexOf("/") >= 0) {
				str = str.replaceAll("/", "-");
			}
		}
		return str;
	}*/

	// 解密uid
	public static String decryptionuid(String s) throws IOException {
		if (s == null) {
			return null;
		}
		if (s.indexOf("*") >= 0) {
			s = s.replaceAll("\\*", "+");
		}
		if (s.indexOf("-") >= 0) {
			s = s.replaceAll("-", "/");
		}
		String str = decryption(s, "DG43AE2F9DCKLD32F8");
		if (isNullorBlank(str)) {
			return null;
		}
		StringTokenizer st = new StringTokenizer(str, "|");
		if (st.countTokens() != 2) {
			return null;
		}
		String uid = st.nextToken();
		String timestamp = st.nextToken();
		if (!isNumeric(uid) || !isNumeric(timestamp)) {
			return null;
		}
		if ((new Date().getTime() - Long.valueOf(timestamp)) / 3600000 > 0) {
			return null;
		}
		return uid;
	}

	// 加密
	public static String encryption(String s, String key)
			throws UnsupportedEncodingException {
		if (s == null || key == null) {
			return null;
		}
		Blowfish bf = new Blowfish();
		bf.setKey(key.getBytes("UTF-8"));
		byte[] bs = s.getBytes();
		bs = bf.encrypt(bs, 0, bs.length);
		return (new sun.misc.BASE64Encoder()).encode(bs);
	}

	// 解密
	public static String decryption(String s, String key) throws IOException {
		if (s == null || key == null) {
			return null;
		}
		if (s != null && s.length() > 5) {
			Blowfish bf = new Blowfish();
			s = s.trim();
			bf.setKey(key.getBytes("UTF-8"));
			byte[] bbb = bf.decrypt((new sun.misc.BASE64Decoder()).decodeBuffer(s));
			return new String(bbb);
		}
		return null;
	}

	// 获取默认字符串
	public static String getDefaultStr(String s) {
		if (s == null) {
			return "";
		}
		return s;
	}

	// 解密uid
	public static Long getUserid(String token) throws IOException {
		if(StringUtils.isEmpty(token)){
			return null;
		}
		String tmp = token.substring(token.length()-1);
		if(tmp.equals("=")){
			if (token.indexOf("*") >= 0) {
				token = token.replaceAll("\\*", "+");
			}
			if (token.indexOf("-") >= 0) {
				token = token.replaceAll("-", "/");
			}
			try{
				String str = decryption(token, SysConst.USERID_KEY);
				if (isNullorBlank(str)) {
					return null;
				}
				StringTokenizer st = new StringTokenizer(str, "|");
				if (st.countTokens() != 3) {
					return null;
				}
				String uid = st.nextToken();
//		String passwd = st.nextToken();
				String timestamp = st.nextToken();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if (!isNumeric(uid)/*|| !isNumeric(timestamp)*/) {
					return null;
				}
				return Long.valueOf(uid);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		ResponseResult result = tokenService.getUserIdByToken(token);
		if(null!=result){
			if(result.getCode().equals("0000")){
				Long userid = (Long) result.getData();
				return userid;
			}else{
				LOGGER.info("调用用户系统异常 "+result.getMessage());
				new Exception("调用用户系统异常"+result.getMessage());
			}
		}else{
			LOGGER.info("调用用户系统异常");
			new Exception("调用用户系统异常");
		}

		return  null;
	}

	// 加密uid
	/*public static String getToken(Long userid, String passwd) {
		if (userid == null || passwd == null) {
			return "";
		}
		passwd = passwd.substring(0, 8);
		String str = null;
		try {
			str = encryption(userid + "|" + passwd + "|" + new Date().getTime(), SysConst.USERID_KEY);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (str != null) {
			if (str.indexOf("+") >= 0) {
				str = str.replaceAll("\\+", "*");
			}
			if (str.indexOf("/") >= 0) {
				str = str.replaceAll("/", "-");
			}
		}
		return str;
	}

	public static void main(String[] args) {
		try {
			System.out
					.println(getUserid("AB0ezLKhbhDnWPPv8MZ2VGlv3HOqUUyXZcGwyt*rGMe5hA=="));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
