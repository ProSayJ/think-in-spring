package prosayj.thinking.spring._09_cglib_proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import prosayj.thinking.spring.common.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Cglib 实现动态代理
 *
 * @author yangjian
 * @date 2021-07-04 下午 03:46
 * @since 1.0.0
 */
public class CglibProxyTest {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Cglib 实现动态代理
     */
    @Test
    @DisplayName("Cglib 实现动态代理")
    public void m1() {
        //1 创建原始对象
        UserService userService = new UserService();
        /*
          2 通过cglib方式创建动态代理对象
            Proxy.newProxyInstance(classloader,interface,invocationhandler)

            Enhancer.setClassLoader()
            Enhancer.setSuperClass()
            Enhancer.setCallback();  ---> MethodInterceptor(cglib)
            Enhancer.create() ---> 代理
         */

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(CglibProxyTest.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());

        MethodInterceptor interceptor = new MethodInterceptor() {
            //等同于 InvocationHandler --- invoke
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                logger.info("------cglib proxy  log before --------");
                Object ret = method.invoke(userService, args);
                logger.info("------cglib proxy  log after --------");
                return ret;
            }
        };

        enhancer.setCallback(interceptor);

        UserService userServiceProxy = (UserService) enhancer.create();

        userServiceProxy.createUser("李四", 24);
        userServiceProxy.login("张三", "123");
    }
}
