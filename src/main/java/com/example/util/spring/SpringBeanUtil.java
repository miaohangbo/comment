package com.example.util.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
* @ClassName: SpringBeanUtil 
* @Description: SpringBeanutil工具类
* @author guokp
*/

public class SpringBeanUtil implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	private static SpringBeanUtil getInstance() {
		return InnerBean.springBeanutil;
	}

	public static <T> T getBean(String name) {
		if (getInstance().applicationContext == null) {
			return null;
		}
		return (T)getInstance().applicationContext.getBean(name);
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	private static class InnerBean {
		public static SpringBeanUtil springBeanutil = new SpringBeanUtil();
	}
}
