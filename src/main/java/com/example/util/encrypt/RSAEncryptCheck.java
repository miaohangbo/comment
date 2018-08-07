/**
 * 
 */
package com.example.util.encrypt;


import com.mysql.jdbc.StringUtils;

/**
 * <desc>RSA密码校验</desc>
 * @author mupeng
 * @date 2017-5-17 下午4:10:46
 * @version 
 */
public class RSAEncryptCheck {
	
	/**
	 * <desc>校验RSA加密的串</desc>
	 * @version 
	 * @author mupeng
	 * @date 2017-5-17 下午4:12:41
	 * @param password
	 * @return
	 * @return boolean
	 * @exception
	 */
	public static boolean passwordCheck(String encodeStr){
		
		if(StringUtils.isNullOrEmpty(encodeStr)){
			return false;
		}
		
		// 验证签名
		boolean status = false;
		try {
			
			byte[] encoderByte = Base64.decode(encodeStr);
			byte[] decoder = RSA.decryptByPrivateKey(encoderByte, RSACommon.RSA_PRIVATE_KEY);
			
			String decodeStr = new String(decoder,"utf-8");
			
			System.out.println("公钥加密后：" + encodeStr);
			System.out.println("私钥解密后：" + decodeStr);
			
			String sign = RSA.sign(encoderByte, RSACommon.RSA_PRIVATE_KEY);
			System.out.println("签名串："+sign);
			status = RSA.verify(encoderByte, RSACommon.RSA_PUBLIC_KEY, sign);
			
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		
		return status;
	}
	
    
}
