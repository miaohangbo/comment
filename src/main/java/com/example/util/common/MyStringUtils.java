package com.example.util.common; /**
 * 
 *//*

package com.example.util.common;


import com.alibaba.druid.util.StringUtils;

*/
/**
 * <desc></desc>
 * @author mupeng
 *//*

public class MyStringUtils extends StringUtils {
	
	*/
/**
	 * 
	 * <desc>字符串判空</desc>
	 * @author mupeng
	 * @date 2017-6-29 下午3:00:47
	 * @param str
	 * @return
	 * boolean
	 *//*

	public static boolean isNullOrBlank(String str){
		if(StringUtils.isNullOrEmpty(str)){
			return true;
		}
		if(str.equals("null")||str.equals("NULL")||str.equals("Null")){
			return true;
		}
		if(StringUtils.isEmptyOrWhitespaceOnly(str)){
			return true;
		}
		return false;
	}
	
	*/
/**
	 * 
	 * <desc>字符串非空</desc>
	 * @author mupeng
	 * @date 2017-6-29 下午3:01:01
	 * @param str
	 * @return
	 * boolean
	 *//*

	public static boolean isNotNullOrNotBlank(String str){
		if(StringUtils.isNullOrEmpty(str)){
			return false;
		}
		if(str.equals("null")||str.equals("NULL")||str.equals("Null")){
			return false;
		}
		if(StringUtils.isEmptyOrWhitespaceOnly(str)){
			return false;
		}
		return true;
	}
	
	public static boolean isNotNullOrNotBlankWithNotNULL(String str){
		if(StringUtils.isNullOrEmpty(str)){
			return false;
		}
		if(StringUtils.isEmptyOrWhitespaceOnly(str)){
			return false;
		}
		return true;
	}
}
*/
