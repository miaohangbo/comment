package com.example.util.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypt {
	
	public static String EncoderByMd5(String str){
		//确定计算方法
		return new MD5().getMD5ofStr(str);
/*		MessageDigest md5=MessageDigest.getInstance("MD5");
 		BASE64Encoder base64en = new BASE64Encoder();
 		//加密后的字符串
 		String pwd = base64en.encode(md5.digest(str.getBytes("utf-8")));
 		
 		return pwd;*/
	}
	
	   // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }
	
	/**
	 * 
	 * <desc>校验密码</desc>
	 * @author mupeng
	 * @date 2017年8月28日 下午4:53:47
	 * @param newpasswd
	 * @param oldpasswd
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static boolean checkpassword(String newpasswd,String oldpasswd) 
			throws NoSuchAlgorithmException, UnsupportedEncodingException{
		if(EncoderByMd5(newpasswd).equals(oldpasswd))
			return true;
		else
			return false;
		}
}
