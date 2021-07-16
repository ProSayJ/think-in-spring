package prosayj.handspring.test.service;

import prosayj.handspring.spring.BeanPostProcessor;
import prosayj.handspring.spring.Component;

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
            ((UserService) bean).setBeanName("ProSayJ");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println(beanName + "---------->初始化之后");
        return bean;
    }
}
