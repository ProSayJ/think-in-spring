package prosayj.spring.iocaop.xml.transfer.pojo;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 通用返回体
 *
 * @author yangjian
 * @date 2021-05-13
 */
@Data
public class Result implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private String status;
    private String message;

    public Result() {
        System.out.println("Result 无参构造器 初始化");
    }

    public void initMethod() {
        System.out.println("init-method....");
    }

    @PostConstruct
    public void postCoustrcut() {
        System.out.println("postCoustrcut");
    }


    @PreDestroy
    public void preDestroy() {
        System.out.println("PreDestroy...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy.....");
    }


    @Override
    public void setBeanName(String name) {
        System.out.println("注册我成为bean时定义的id：" + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("管理我的beanfactory为：" + beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("高级容器接口ApplicationContext：" + applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet......");
    }
}
