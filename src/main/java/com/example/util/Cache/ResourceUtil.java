package com.example.util.Cache;

import java.util.ResourceBundle;

/**
 * 项目参数工具类
 * 
 */
public class ResourceUtil {

	private static final ResourceBundle redis = ResourceBundle.getBundle("config/properties/redis");
	
	/**
	 * 获取配置文件参数
	 * 
	 * @param name
	 * @return
	 */
	public static final int getConfigRedis(String name) {
		
		String index=redis.getString(name);
		return Integer.parseInt(index);
	}
	
	
	public static Object getObject(String key){
		return redis.getObject(key);
	}
	
	
}
