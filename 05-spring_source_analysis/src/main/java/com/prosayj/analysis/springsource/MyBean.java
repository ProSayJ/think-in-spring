package com.prosayj.analysis.springsource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-05-18
 */
public class MyBean implements InitializingBean, ApplicationContextAware {

	private ItBean itBean;

	public void setItBean(ItBean itBean) {
		this.itBean = itBean;
	}

	/**
	 * 构造函数
	 */
	public MyBean(){
		System.out.println("MyBean 构造器...");
	}


	/**
	 * InitializingBean 接口实现
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("MyBean afterPropertiesSet...");
	}

	public void print() {
		System.out.println("print方法业务逻辑执行");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setApplicationContext....");
	}
}
