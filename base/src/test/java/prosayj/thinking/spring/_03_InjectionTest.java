//package prosayj.thinking.spring;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;
//import prosayj.thinking.spring.injection.CustomerDomain;
//import prosayj.thinking.spring.iochelloworld.domain.Person;
//import prosayj.thinking.spring.iochelloworld.UserService;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
///**
// * SpringInjectionTest
// *
// * @author yangjian
// * @date 2021-01-02 上午 12:16
// * @since 1.0.0
// */
//public class _03_InjectionTest extends ClasspathContextSetEnv {
//    public _03_InjectionTest() {
//        super("/applicationContext.xml");
//    }
//
//    /**
//     * Spring容器 8种基本类型自动注入
//     */
//    @Test
//    @DisplayName("Spring容器 8种基本类型自动注入 测试")
//    public void testInjection() {
//        //通过工厂类获得对象
//        CustomerDomain bean = (CustomerDomain) context.getBean("customer");
//        assertNotNull(bean);
//        logger.info("通过 id 获取bean:\n{}", bean);
//    }
//
//    @Test
//    @DisplayName("01-自动注入-属性 property 注入 测试")
//    public void testInjection2() {
//        //通过工厂类获得对象
//        UserService userService = (UserService) context.getBean("userService");
//        assertNotNull(userService);
//        userService.createUser("李四,", 23);
//        userService.login("王五", "xas");
//    }
//
//    @Test
//    @DisplayName("02-自动注入-基于p名称空间的property简化写法 测试")
//    public void testInjection3() {
//        //通过工厂类获得对象
//        Person person = (Person) context.getBean("person1");
//        assertNotNull(person);
//        logger.info("通过 id 获取bean:{}", person);
//    }
//
//    /**
//     * 自动注入-构造注入 测试
//     * 多构造参数的情况：
//     * 1：可以通过控制 constructor-arg 标签的数量来确定具体的重载方法的使用
//     * 2：构造参数个数相同时，通过在标签引入 type 属性 进⾏类型的区分 <constructor-arg type="">
//     */
//    @Test
//    @DisplayName("03-自动注入-构造注入 测试")
//    public void testInjection4() {
//        Person injectionByContract01 = (Person) context.getBean("/person");
//        assertNotNull(injectionByContract01);
//        logger.info("通过 id 获取bean:{}", injectionByContract01);
//
//        Person injectionByContract02 = (Person) context.getBean("person2");
//        assertNotNull(injectionByContract02);
//        logger.info("通过 id 获取bean:{}", injectionByContract02);
//
//        Person injectionByContract03 = (Person) context.getBean("person3");
//        assertNotNull(injectionByContract03);
//        logger.info("通过 id 获取bean:{}", injectionByContract03);
//    }
//}
