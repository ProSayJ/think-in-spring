package prosayj.thinking.spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prosayj.thinking.spring.base.BaseEnv;
import prosayj.thinking.spring.beanpost.Category;
import prosayj.thinking.spring.lifecycle.Product;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SpringBeanLifeTest
 *
 * @author yangjian201127@credithc.com
 * @date 2021-01-02 下午 09:34
 * @since 1.0.0
 */
public class BeanLifeCycleTest extends BaseEnv {
    @Test
    @DisplayName("00-测试 Spring bean生命周期 接口")
    public void testBeanLifeCycleTest() {
        //通过工厂类获得对象
        Product bean = (Product) context.getBean("product");
        assertNotNull(bean);
        logger.info("通过 id 获取bean:{}", bean);
    }

    @Test
    @DisplayName("01-测试 Spring BeanPostProcessor")
    public void testBeanPostProcessorTest() {
        Category categroy = (Category) context.getBean("categroy");
        assertEquals(categroy.getName(), "安徽");
    }
}

