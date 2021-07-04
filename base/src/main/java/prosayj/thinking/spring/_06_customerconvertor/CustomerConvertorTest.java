package prosayj.thinking.spring._06_customerconvertor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;
import prosayj.thinking.spring.common.util.JsonUtils;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 自定义转换器
 *
 * @author yangjian
 * @date 2021-01-02 下午 10:27
 * @since 1.0.0
 */
public class CustomerConvertorTest extends ClasspathContextSetEnv {
    public CustomerConvertorTest() {
        super("test/06CustomerConvertorTest.xml");
    }

    @Test
    @DisplayName("Spring 容器 自定义转换器")
    public void testCustomerConvertor() {
        Account account = context.getBean("scopeSingleton", Account.class);
        assertNotNull(account);
        logger.info("通过 beanId + beanClass 获取bean:\n{}", JsonUtils.toPrettyJson(account));
    }
}
