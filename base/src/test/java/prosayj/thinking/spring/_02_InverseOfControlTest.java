package prosayj.thinking.spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;
import prosayj.thinking.spring.factotybean.ConnectionFactoryBean;
import prosayj.thinking.spring.scope.Account;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * SpringInverseOfControlTest
 *
 * @author yangjian
 * @date 2021-01-02 上午 12:26
 * @since 1.0.0
 */
public class _02_InverseOfControlTest extends ClasspathContextSetEnv {
    public _02_InverseOfControlTest() {
        super("/applicationContext.xml");
    }

    @Test
    @DisplayName("00-测试 factoryBean 接口")
    public void testFactoryBean() {
        Connection connection = (Connection) context.getBean("conn");
        assertNotNull(connection);
        logger.info("通过 id 获取 connection :\n{}", connection);

        ConnectionFactoryBean connectionFactoryBean = (ConnectionFactoryBean) context.getBean("&conn");
        assertNotNull(connectionFactoryBean);
        logger.info("通过 id 获取 ConnectionFactoryBean :\n{}", connectionFactoryBean);

        //数据库连接不能公用一个实例
        assertNotEquals(context.getBean("conn"), context.getBean("conn"));
    }

    @Test
    @DisplayName("01-测试 实例工厂 接口")
    public void testInstanceFactoryBean() {
        Connection connection = (Connection) context.getBean("conn2");
        assertNotNull(connection);
        logger.info("通过 id 获取 connection :{}", connection);
    }

    @Test
    @DisplayName("02-测试 静态工厂 接口")
    public void testStaticFactoryBean() {
        Connection connection = (Connection) context.getBean("conn3");
        assertNotNull(connection);
        logger.info("通过 id 获取 connection :{}", connection);
    }

    @Test
    @DisplayName("03-测试 Spring 控制创建简单对象次数 接口")
    public void testSpringFactoryBean() {
        Account scopeSingleton = context.getBean("scopeSingleton", Account.class);
        Account scopeSingleton1 = context.getBean("scopeSingleton", Account.class);
        Account scopePrototype = context.getBean("scopePrototype", Account.class);
        Account scopePrototype1 = context.getBean("scopePrototype", Account.class);
        assertEquals(scopeSingleton, scopeSingleton1);
    }
}
