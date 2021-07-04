package prosayj.thinking.spring._04_bean_lifecycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        //通过工厂类获得对象
        LifeCycleDomin bean = (LifeCycleDomin) context.getBean("lifeCycleDomin");
        assertNotNull(bean);
        logger.info("通过 id 获取bean:=====>{}", bean);
    }

}

