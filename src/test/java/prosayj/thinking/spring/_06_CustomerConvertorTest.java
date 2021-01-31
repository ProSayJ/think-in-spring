package prosayj.thinking.spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prosayj.thinking.spring.base.BaseEnv;
import prosayj.thinking.spring.scope.Account;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CustomerConvertorTest
 *
 * @author yangjian
 * @date 2021-01-02 下午 10:27
 * @since 1.0.0
 */
public class _06_CustomerConvertorTest extends BaseEnv {

    @Test
    @DisplayName("00-测试 Spring 控制创建简单对象次数 接口")
    public void testCustomerConvertor() {
        Account account = context.getBean("scopeSingleton", Account.class);
        assertNotNull(account);
        logger.info("通过 beanId + beanClass 获取bean:\n{}", account);
    }
}
