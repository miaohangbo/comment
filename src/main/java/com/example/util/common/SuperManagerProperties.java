/**
 * 
 */
package com.example.util.common;

/**
 * 
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class SuperManagerProperties {

	private static List<String> idList;
	static {
		Properties proper = new Properties();
		try {
			proper.load(SuperManagerProperties.class.getResourceAsStream("/resources/superManager.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String property = proper.getProperty("idList");
		idList = Arrays.asList(property.split(","));
	}
	
	public static List<String> getIdList() {
		return idList;
	}

}
