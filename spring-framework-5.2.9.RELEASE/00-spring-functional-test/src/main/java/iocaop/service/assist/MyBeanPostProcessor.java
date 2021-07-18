package iocaop.service.assist;


import iocaop.service.UserService;
import iocaop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-07-16 下午 01:03
 * @since 1.0.0
 */
@Component(value = "myBeanPostProcessor")
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println(beanName + "---------->初始化之前");
        if ("userService".equals(beanName)) {
            ((UserServiceImpl) bean).setBeanName("ProSayJ");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println(beanName + "---------->初始化之后");
        if (bean instanceof UserService) {
            return Proxy.newProxyInstance(
                    MyBeanPostProcessor.class.getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            //找切入点，判断是否需要执行 AOP 增强
                            System.out.println("userService 执行代理方法 开始");

                            Object invokeResult = method.invoke(bean, args);

                            System.out.println("userService 执行代理方法 结束");
                            return invokeResult;
                        }
                    });
        }
        return bean;
    }
}
