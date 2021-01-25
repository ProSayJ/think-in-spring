package prosayj.thinking.spring.beanpost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * MyBeanPostProcessor
 *
 * @author yangjian201127@credithc.com
 * @date 2021-01-03 下午 01:42
 * @since 1.0.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Category) {
            Category category = (Category) bean;
            category.setName("安徽");
            return category;
        } else {
            return bean;
        }
    }
}