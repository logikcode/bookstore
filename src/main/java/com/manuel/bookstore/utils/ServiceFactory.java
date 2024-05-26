package com.manuel.bookstore.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory implements BeanFactoryAware {
	
	private static BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		ServiceFactory.beanFactory = beanFactory;
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return beanFactory.getBean(clazz);
	}

	public static <T> T getBean(String beanName, Class<T> clazz){
		return beanFactory.getBean(beanName,clazz);
	}
}
