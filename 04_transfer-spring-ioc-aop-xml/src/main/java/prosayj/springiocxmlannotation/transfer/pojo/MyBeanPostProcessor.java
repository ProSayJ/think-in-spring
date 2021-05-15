package prosayj.springiocxmlannotation.transfer.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 拦截实例化之后的对象(实例化了并且属性注入了)
 *
 * @author yangjian
 * @date 2021-05-13
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("lazyResult".equalsIgnoreCase(beanName)) {
            System.out.println("MyBeanPostProcessor  before方法拦截处理lazyResult");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("lazyResult".equalsIgnoreCase(beanName)) {
            System.out.println("MyBeanPostProcessor  after方法拦截处理lazyResult");
        }
        return bean;
    }
}
