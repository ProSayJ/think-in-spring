package prosayj.thinking.spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prosayj.thinking.spring.base.BaseEnv;
import prosayj.thinking.spring.basic.service.UserService;
import prosayj.thinking.spring.proxy.staticproxy.UserServiceProxy;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * _07_ProxyTest
 *
 * @author yangjian
 * @date 2021-01-02 下午 10:27
 * @since 1.0.0
 */
public class _07_ProxyTest extends BaseEnv {
    @Test
    @DisplayName("00-测试 静态代理")
    public void testStaticProxy() {
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.login("zs", "123");
        userServiceProxy.createUser("li", 23);
    }

    @Test
    @DisplayName("01-测试 动态代理")
    public void testDynamicProxy() {
        UserService userService = context.getBean("userService", UserService.class);
        userService.login("zs","123");
    }
}
