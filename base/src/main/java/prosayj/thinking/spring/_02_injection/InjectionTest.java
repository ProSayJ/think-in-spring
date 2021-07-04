package prosayj.thinking.spring._02_injection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;
import prosayj.thinking.spring.common.service.UserService;
import prosayj.thinking.spring.common.util.JsonUtils;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Spring容器 依赖注入的两种方式测试用例：
 * <br>1:设值注入
 * <br>2:构造注入
 * <p>
 *
 * @author yangjian
 * @date 2020-12-25 13:41
 * @since 1.0.0
 */
public class InjectionTest extends ClasspathContextSetEnv {

    public InjectionTest() {
        super("test/InjectionTest.xml");
    }

    //------------------------------------------设值注入------start
    /**
     * Spring容器 property 属性注入：
     * <br> 1、8种基本类型+String
     * <br> 2、数组
     * <br> 3、list 集合
     * <br> 4、set 集合
     * <br> 5、map 集合
     * <br> 6、properties 属性
     */
    @Test
    @DisplayName("Spring容器 property 属性注入")
    public void testInjection() {
        //通过工厂类获得对象
        CustomerDomain bean = (CustomerDomain) context.getBean("customer");
        assertNotNull(bean);
        logger.info("通过 id 获取bean==>{}", JsonUtils.toPrettyJson(bean));
    }

    /**
     * Spring容器 property 属性注入:
     * <br>基于p名称空间的简化写法
     */
    @Test
    @DisplayName("Spring容器 property 属性注入 基于p名称空间的简化写法")
    public void testInjection222() {
        //通过工厂类获得对象
        CustomerDomain person = (CustomerDomain) context.getBean("customer2");
        assertNotNull(person);
        logger.info("通过 id 获取bean:{}", person);
    }

    /**
     * Spring容器 property 属性注入:
     * <br> 对象属性 property 注入
     */
    @Test
    @DisplayName("Spring容器 对象属性property注入")
    public void testInjection333() {
        //通过工厂类获得对象
        UserService userService = (UserService) context.getBean("userService");
        assertNotNull(userService);
        userService.createUser("李四,", 23);
        userService.login("王五", "xas");
    }
    //------------------------------------------设值注入------end



    //------------------------------------------构造注入------start
    /**
     * Spring容器 构造 注入：
     * <br>多构造参数的情况：
     * <br>1：可以通过控制 constructor-arg 标签的数量来确定具体的重载方法的使用
     * <br>2：构造参数个数相同时，通过在标签引入 type 属性 进⾏类型的区分
     * <p>
     * <constructor-arg type=''/>
     */
    @Test
    @DisplayName("Spring容器 构造 注入")
    public void testInjection4() {
        CustomerDomain injectionByContract01 = (CustomerDomain) context.getBean("customer2");
        assertNotNull(injectionByContract01);
        logger.info("通过 id 获取bean:{}", injectionByContract01);

        CustomerDomain injectionByContract02 = (CustomerDomain) context.getBean("customer3");
        assertNotNull(injectionByContract02);
        logger.info("通过 id 获取bean:{}", injectionByContract02);

        CustomerDomain injectionByContract03 = (CustomerDomain) context.getBean("customer3");
        assertNotNull(injectionByContract03);
        logger.info("通过 id 获取bean:{}", injectionByContract03);
    }
    //------------------------------------------构造注入------end


}
