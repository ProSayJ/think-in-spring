package prosayj.thinking.spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import prosayj.thinking.spring.base.BaseEnv;
import prosayj.thinking.spring.beanpost.Category;
import prosayj.thinking.spring.lifecycle.LifeCycleDomin;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 演示生命周期
 *
 * @author yangjian201127@credithc.com
 * @date 2021-01-02 下午 09:34
 * @since 1.0.0
 */
public class _05_BeanLifeCycleTest extends BaseEnv {
    @Test
    @DisplayName("00- Spring bean生命周期：bean初始化时机")
    public void testBeanLifeCycleTest() {
        //通过工厂类获得对象
        LifeCycleDomin bean = (LifeCycleDomin) context.getBean("lifeCycleDomin");
        assertNotNull(bean);
        logger.info("通过 id 获取bean:\n{}", bean);
        if (context != null && context instanceof ClassPathXmlApplicationContext) {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }

    @Test
    @DisplayName("01-Spring bean生命周期：BeanPostProcessor")
    public void testBeanPostProcessorTest() {
        Category categroy = (Category) context.getBean("categroy");
        assertEquals(categroy.getName(), "安徽");
    }
}

