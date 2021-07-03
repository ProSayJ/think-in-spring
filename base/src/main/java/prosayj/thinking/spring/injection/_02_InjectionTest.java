package prosayj.thinking.spring.injection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;
import prosayj.thinking.spring.iochelloworld.UserService;
import prosayj.thinking.spring.common.util.JsonUtils;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * SpringIocHelloWorldTest
 *
 * @author yangjian
 * @date 2020-12-25 13:41
 * @since 1.0.0
 */
public class _02_InjectionTest extends ClasspathContextSetEnv {

    public _02_InjectionTest() {
        super("test/InjectionTest.xml");
    }

    /**
     * Spring容器 8种基本类型自动注入
     */
    @Test
    @DisplayName("Spring容器 8种基本类型自动注入")
    public void testInjection() {
        //通过工厂类获得对象
        CustomerDomain bean = (CustomerDomain) context.getBean("customer");
        assertNotNull(bean);
        logger.info("通过 id 获取bean:\n{}", JsonUtils.toPrettyJson(bean));
    }


    @Test
    @DisplayName("自动注入-基于p名称空间的property简化写法 测试")
    public void testInjection3() {
        //通过工厂类获得对象
        CustomerDomain person = (CustomerDomain) context.getBean("customer2");
        assertNotNull(person);
        logger.info("通过 id 获取bean:{}", person);
    }


    /**
     * 自动注入-构造注入 测试
     * 多构造参数的情况：
     * 1：可以通过控制 constructor-arg 标签的数量来确定具体的重载方法的使用
     * 2：构造参数个数相同时，通过在标签引入 type 属性 进⾏类型的区分 <constructor-arg type="">
     */
    @Test
    @DisplayName("构造注入")
    public void testInjection4() {
        CustomerDomain injectionByContract01 = (CustomerDomain) context.getBean("customer3");
        assertNotNull(injectionByContract01);
        logger.info("通过 id 获取bean:{}", injectionByContract01);

        CustomerDomain injectionByContract02 = (CustomerDomain) context.getBean("customer4");
        assertNotNull(injectionByContract02);
        logger.info("通过 id 获取bean:{}", injectionByContract02);

        CustomerDomain injectionByContract03 = (CustomerDomain) context.getBean("customer5");
        assertNotNull(injectionByContract03);
        logger.info("通过 id 获取bean:{}", injectionByContract03);
    }


    /**
     * 对象属性property注入
     */
    @Test
    @DisplayName("对象属性property注入")
    public void testInjection2() {
        //通过工厂类获得对象
        UserService userService = (UserService) context.getBean("userService");
        assertNotNull(userService);
        userService.createUser("李四,", 23);
        userService.login("王五", "xas");
    }

}
