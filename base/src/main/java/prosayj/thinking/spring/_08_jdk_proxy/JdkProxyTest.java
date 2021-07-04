package prosayj.thinking.spring._08_jdk_proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK实现动态代理
 *
 * @author yangjian
 * @date 2021-07-04 下午 03:46
 * @since 1.0.0
 */
public class JdkProxyTest {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    @DisplayName("JDK实现动态代理")
    public void m1() {
        //1 创建原始对象
        UserService userService = new UserServiceImpl();
        //2 JDK创建动态代理并执行目标方法
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                logger.info("------jdk proxy  log before --------");

                Object invoke = method.invoke(userService, args);

                logger.info("------jdk proxy  log after --------");
                return invoke;
            }
        };
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(
                UserServiceImpl.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                handler);
        userServiceProxy.createUser("张三", 123);
        userServiceProxy.login("张三", "123456");
    }
}
