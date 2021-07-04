package prosayj.thinking.spring._05_configuration_parameterization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 配置文件参数化
 * 
 *
 * @author yangjian
 * @date 2021-01-02 上午 12:26
 * @since 1.0.0
 */
public class ConfigurationParameterizationTest extends ClasspathContextSetEnv {
    public ConfigurationParameterizationTest() {
        super("test/05_ConfigurationParameterizationTest.xml");
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

        //数据库连接不能公用一个实例
        assertNotEquals(context.getBean("conn"), context.getBean("conn"));
    }
}
