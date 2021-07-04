package prosayj.thinking.spring._02_inverseofcontroller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Spring容器 控制反转[Spring容器创建Bean的几种方式]测试用例：
 *
 * @author yangjian
 * @date 2020-12-25 13:41
 * @since 1.0.0
 */
public class InverseOfControlTest extends ClasspathContextSetEnv {

    public InverseOfControlTest() {
        super("test/02InverseOfControlTest.xml");
    }


    //------------------------------------------Spring 控制反转  实例化 bean------start


    /**
     * 自定义的 实例工厂 factory-method 来实例化 bean ：
     * {@link UserDomianFactory}
     */
    @Test
    @DisplayName("Spring容器 通过 自定义的 实例工厂 factory-method 来实例化 bean ")
    public void inverseOfControlTest1() {
        UserDomain injectionByUserDomianFactory = (UserDomain) context.getBean("userDomain");
        assertNotNull(injectionByUserDomianFactory);
        logger.info("通过 id 获取bean:{}", injectionByUserDomianFactory);
    }

    /**
     * 通过 自定义的 静态工厂 来实例化 bean：
     * <p>{@link  StaticUserDomianFactory}
     */
    @Test
    @DisplayName("通过 自定义的 静态工厂 来实例化 bean")
    public void inverseOfControlTest2() {

        UserDomain injectionByStaticUserDomianFactory = (UserDomain) context.getBean("userDomain2");
        assertNotNull(injectionByStaticUserDomianFactory);
        logger.info("通过 id 获取bean:{}", injectionByStaticUserDomianFactory);

    }

    /**
     * 通过 自定义的 {@link  UserDomainFactoryBean}
     * 实现 FactoryBean 来实例化 bean;
     * <p>可以通过实现{@link org.springframework.beans.factory.FactoryBean#isSingleton()}这个接口的方法，
     * 来控制是否生成单例 Bean还是原型 Bean
     */
    @Test
    @DisplayName("通过 自定义的 UserDomainFactoryBean 实现 FactoryBean 来实例化 bean")
    public void inverseOfControlTest3() {
        UserDomain injectionByUserDomianFactoryBean = (UserDomain) context.getBean("userDomain3");
        assertNotNull(injectionByUserDomianFactoryBean);
        logger.info("通过 id 获取bean:{}", injectionByUserDomianFactoryBean);
    }

//
//    /**
//     * Spring容器 bean 作用域
//     */
//    @Test
//    @DisplayName("Spring容器 bean 作用域")
//    public void testInjection8() {
//        Account scopeSingleton = context.getBean("scopeSingleton", Account.class);
//        Account scopeSingleton1 = context.getBean("scopeSingleton", Account.class);
//        Account scopePrototype = context.getBean("scopePrototype", Account.class);
//        Account scopePrototype1 = context.getBean("scopePrototype", Account.class);
//        assertEquals(scopeSingleton, scopeSingleton1);
//        assertNotEquals(scopePrototype, scopePrototype1);
//    }

}
