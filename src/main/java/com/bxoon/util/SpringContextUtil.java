/**
 * 
 */
package com.bxoon.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * 获取spring容器，以访问容器中定义的其他bean .
 * 
 * @author li.chunxing .
 * 
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

	/**
	 * applicationContext .
	 */
	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境 .
	 * 
	 * @param applicationContext
	 *            .
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext .
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 获取对象 这里重写了bean方法，起主要作用 .
	 * 
	 * @param name .
	 * @return Object 一个以所给名字注册的bean的实例 .
	 * @throws BeansException .
	 */
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}
	/**
	 * 获取对象 这里重写了bean方法，起主要作用 .
	 * @param <T>
	 * 
	 * @param name .
	 * @return Object 一个以所给名字注册的bean的实例 .
	 * @throws BeansException .
	 */
	public static <T> T getBean(String name,Class<T> clazz) throws BeansException {
		return applicationContext.getBean(name,clazz);
	}
	/**
	 * 获取对象 这里重写了bean方法，起主要作用 .
	 * @param <T>
	 * 
	 * @param name .
	 * @return Object 一个以所给名字注册的bean的实例 .
	 * @throws BeansException .
	 */
	public static <T> T getBean(Class<T> clazz) throws BeansException {
		return applicationContext.getBean(clazz);
	}
}
