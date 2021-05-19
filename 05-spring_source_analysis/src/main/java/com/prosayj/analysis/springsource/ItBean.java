package com.prosayj.analysis.springsource;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-05-18
 */
public class ItBean {

	private MyBean lagouBean;

	public void setLagouBean(MyBean lagouBean) {
		this.lagouBean = lagouBean;
	}

	/**
	 * 构造函数
	 */
	public ItBean(){
		System.out.println("ItBean 构造器...");
	}
}
