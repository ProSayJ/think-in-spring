package com.prosayj.analysis.springsource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * MyBeanFactoryPostProcessor
 *
 * @author yangjian
 * @date 2021-05-18
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public MyBeanFactoryPostProcessor() {
		System.out.println("BeanFactoryPostProcessor的实现类构造函数...");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("BeanFactoryPostProcessor的实现方法调用中......");
	}
}