package prosayj.thinking.spring._07_static_proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 手动静态代理测试类
 * @author yangjian
 * @date 2021-07-04 下午 03:46
 * @since 1.0.0
 */
public class MainTest {
    @Test
    @DisplayName("手动实现静态代理")
    public void m1() {
        UserService userService = new UserServiceProxy();
        userService.createUser("张三", 23);
        userService.login("张三", "123");
    }
}
