package prosayj.thinking.spring._04_bean_lifecycle;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * LifeCycleDomin
 *
 * @author yangjian
 * @date 2021-01-02 下午 09:28
 * @since 1.0.0
 */
@ToString
class LifeCycleDomin2 implements InitializingBean, BeanNameAware, BeanFactoryAware {

    private String userName;

    public LifeCycleDomin2() {
        System.out.println(">>>> UserService");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(">>>> postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(">>>> preDestroy");
    }

    public void init() {
        System.out.println(">>>> init");
    }

    public void destory() {
        System.out.println(">>>> destory");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(">>>> setBeanFactory");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println(">>>> setBeanName");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(">>>> afterPropertiesSet");
    }
}