/**
 * 
 */
package com.example.util.password;



import com.example.util.encrypt.MD5;

import java.util.Random;

/**
 * <desc></desc>
 * @author mupeng
 */
public class PasswordUtil {
	
	public static String getRandomString(int length) { //length表示生成字符串的长度  
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }
	
	/**
	 * 
	 * <desc>生成8位随机密码</desc>
	 * @author mupeng
	 * @date 2017-6-29 下午4:08:34
	 * @param
	 * @return
	 * String
	 */
	public static String getRandomPassword() { //length表示生成字符串的长度  
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < 8; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }
	public static String getMd5Pswd(String password) {
		if (password == null) {
			password = "";
		}
		return new MD5().getMD5ofStr(password);
	}
}
