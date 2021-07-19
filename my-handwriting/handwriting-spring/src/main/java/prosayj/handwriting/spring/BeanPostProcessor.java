package prosayj.handwriting.spring;


/**
 * BeanPostProcessor
 *
 * @author yangjian
 * @since 1.0.0 <br> 2021-07-16 下午 01:02
 */
public interface BeanPostProcessor {
    /**
     * postProcessBeforeInitialization
     *
     * @param bean     bean
     * @param beanName beanName
     * @return Object
     */
    default Object postProcessBeforeInitialization(Object bean, String beanName) /*throws BeansException */ {
        return bean;
    }

    /**
     * postProcessAfterInitialization
     *
     * @param bean     bean
     * @param beanName beanName
     * @return Object
     */
    default Object postProcessAfterInitialization(Object bean, String beanName) /*throws BeansException */ {
        return bean;
    }
}