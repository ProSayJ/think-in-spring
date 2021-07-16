package prosayj.thinking.spring._04_bean_lifecycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 演示 Spring Bean 的生命周期
 *
 * @author yangjian
 * @date 2021-01-02 下午 09:34
 * @since 1.0.0
 */
public class BeanLifeCycleTest extends ClasspathContextSetEnv {

    public BeanLifeCycleTest() {
        super("test/04_BeanLifeCycleTest.xml");
    }

    /**
     * Spring Bean 的生命周期：bean初始化时机:
     * <br> 1、如果⼀个对象既实现 InitializingBean 接口。同时⼜提供了普通的初始化方法，
     * 先执行 InitializingBean 接口重写的方法，再执行普通初始化方法。
     * <br> 2、注入⼀定发生在初始化操作的前面。
     * <br> 3、销毁方法的操作只适用于 scope="singleton"，初始化操作都适用。
     */
    @Test
    @DisplayName("Spring Bean 的生命周期：初始化、构建完成以后、销毁以后")
    public void testBeanLifeCycleTest() {
        AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("test/04_BeanLifeCycleTest.xml");
        context2.registerShutdownHook();
        //通过工厂类获得对象
        LifeCycleDomin bean = (LifeCycleDomin) context2.getBean("lifeCycleDomin");
        assertNotNull(bean);
        logger.info("容器准备关闭");
        context2.close();
        logger.info("容器关闭完成");
    }

    @Test
    @DisplayName("Spring Bean 的生命周期：初始化、构建完成以后、销毁以后")
    public void testBeanLifeCycleTest2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test/04_BeanLifeCycleTest.xml");
        LifeCycleDomin2 bean = context.getBean(LifeCycleDomin2.class);
        bean.setUserName("张三");
        context.close();
    }

}




