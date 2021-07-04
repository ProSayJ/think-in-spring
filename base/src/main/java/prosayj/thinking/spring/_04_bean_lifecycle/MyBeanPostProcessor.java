package prosayj.thinking.spring._04_bean_lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * BeanPostProcessor 作用：对 Spring 工厂所创建的对象，进行再加工。（AOP 的底层实现）
 *
 * @author yangjian
 * @date 2021-01-03 下午 01:42
 * @since 1.0.0
 */
class MyBeanPostProcessor implements BeanPostProcessor {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifeCycleDomin) {
            logger.info("MyBeanPostProcessor.postProcessBeforeInitialization 执行~~~");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifeCycleDomin) {
            logger.info("MyBeanPostProcessor.postProcessAfterInitialization 执行~~~");
            LifeCycleDomin category = (LifeCycleDomin) bean;
            category.setName("安徽~~~");
            return category;
        } else {
            return bean;
        }
    }
}