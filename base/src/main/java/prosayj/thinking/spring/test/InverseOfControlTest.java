package prosayj.thinking.spring.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;
import prosayj.thinking.spring.factotybean.ConnectionFactoryBean;
import prosayj.thinking.spring.scope.Account;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SpringInverseOfControlTest
 *
 * @author yangjian
 * @date 2021-01-02 上午 12:26
 * @since 1.0.0
 */
public class InverseOfControlTest extends ClasspathContextSetEnv {
    public InverseOfControlTest() {
        super("test/InverseOfControlTest.xml");
    }

    /**
     * Spring容器 通过  自定义的 ConnectionFactoryBean 实现 FactoryBean 来实例化 bean
     * <p>数据库连接不能公用一个实例 {@link ConnectionFactoryBean#isSingleton()}
     */
    @Test
    @DisplayName("Spring容器 通过  自定义的 ConnectionFactoryBean 实现 FactoryBean 来实例化 bean")
    public void testFactoryBean() {
        Connection connection = (Connection) context.getBean("conn");
        assertNotNull(connection);
        logger.info("通过 id 获取 connection :\n{}", connection);

        ConnectionFactoryBean connectionFactoryBean = (ConnectionFactoryBean) context.getBean("&conn");
        assertNotNull(connectionFactoryBean);
        logger.info("通过 id 获取 ConnectionFactoryBean :\n{}", connectionFactoryBean);

        //数据库连接不能公用一个实例 {@link}
        assertNotEquals(context.getBean("conn"), context.getBean("conn"));
    }

    /**
     * Spring容器 通过 自定义的 实例工厂 factory-method 来实例化 bean
     */
    @Test
    @DisplayName("Spring容器 通过 自定义的 实例工厂 factory-method 来实例化 bean")
    public void testInstanceFactoryBean() {
        Connection connection = (Connection) context.getBean("conn2");
        assertNotNull(connection);
        logger.info("通过 id 获取 connection :{}", connection);
    }

    /**
     * Spring容器 通过 自定义的 静态工厂 来实例化 bean
     */
    @Test
    @DisplayName("Spring容器 通过 自定义的 静态工厂 来实例化 bean")
    public void testStaticFactoryBean() {
        Connection connection = (Connection) context.getBean("conn3");
        assertNotNull(connection);
        logger.info("通过 id 获取 connection :{}", connection);
    }

    /**
     * Spring容器 bean 作用域
     */
    @Test
    @DisplayName("Spring容器 bean 作用域")
    public void testSpringFactoryBean() {
        Account scopeSingleton = context.getBean("scopeSingleton", Account.class);
        Account scopeSingleton1 = context.getBean("scopeSingleton", Account.class);
        Account scopePrototype = context.getBean("scopePrototype", Account.class);
        Account scopePrototype1 = context.getBean("scopePrototype", Account.class);
        assertEquals(scopeSingleton, scopeSingleton1);
        assertNotEquals(scopePrototype, scopePrototype1);
    }
}
