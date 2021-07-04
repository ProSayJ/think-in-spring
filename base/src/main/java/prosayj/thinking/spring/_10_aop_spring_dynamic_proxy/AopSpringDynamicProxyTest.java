package prosayj.thinking.spring._10_aop_spring_dynamic_proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Spring容器 控制反转[Spring容器创建Bean的几种方式]测试用例：
 *
 * @author yangjian
 * @date 2020-12-25 13:41
 * @since 1.0.0
 */
public class AopSpringDynamicProxyTest extends ClasspathContextSetEnv {
    public AopSpringDynamicProxyTest() {
        super("test/08_AopSpringDynamicProxyTest.xml");
    }


    /**
     * Spring容器 实例化 bean:
     */
    @Test
    @DisplayName("Spring容器 实例化 bean ")
    public void inverseOfControlTest1() {
        UserService userService = context.getBean(UserService.class);
        assertNotNull(userService);
        userService.createUser("张三",123);
        userService.login("张三","abc");
    }

}
