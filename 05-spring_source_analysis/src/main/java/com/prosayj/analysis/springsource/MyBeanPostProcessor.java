package com.prosayj.analysis.springsource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * MyBeanPostProcessor
 *
 * @author yangjian
 * @date 2021-05-18
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        System.out.println("BeanPostProcessor 实现类构造函数...");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("lagouBean".equals(beanName)) {
            System.out.println("BeanPostProcessor 实现类 postProcessBeforeInitialization 方法被调用中......");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("lagouBean".equals(beanName)) {
            System.out.println("BeanPostProcessor 实现类 postProcessAfterInitialization 方法被调用中......");
        }
        return bean;
    }
}