package prosayj.thinking.spring._01_ioc_hello_world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;
import prosayj.thinking.spring.common.util.JsonUtils;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Spring容器 helloWorld测试用例：
 * <p>1：配置源信息
 * <p>2：实例化容器
 *
 * @author yangjian
 * @date 2020-12-25 13:41
 * @since 1.0.0
 */
public class A_IocHelloWorldTest extends ClasspathContextSetEnv {

    public A_IocHelloWorldTest() {
        super("test/01_IocHelloWorldTest.xml");
    }

    /**
     * 手动创建bean对象
     */
    @Test
    @DisplayName("手动创建bean对象")
    public void createBean() {
        new UserServiceImpl();
    }


    /**
     * 自定义工厂通过反射创建对象
     */
    @DisplayName("自定义工厂通过反射创建对象")
    @Test
    public void customerBeanFactoryGetBean() {
        assertNotNull(CustomerBeanFactory.getUserService());
        UserService userService = (UserService) CustomerBeanFactory.getBean("userService");
        assertNotNull(userService);
        logger.info("userService is :\n{}", JsonUtils.toJson(userService));
    }

    /**
     * Spring容器 通过 benaId 获取 bean
     */
    @DisplayName("Spring容器 通过 benaId 获取 bean")
    @Test
    public void getBeanById() {
        PersonDomain bean = (PersonDomain) context.getBean("person");
        assertNotNull(bean);
        logger.info("Spring容器 id 获取bean:\n{}", bean);
    }


    /**
     * Spring容器 通过 benaName 获取 bean
     */
    @DisplayName("Spring容器 通过 benaName 获取 bean")
    @Test
    public void getBeanByName() {
        PersonDomain bean1 = (PersonDomain) context.getBean("personName1");
        assertNotNull(bean1);
        logger.info("Spring容器 beanName[personName1] 获取bean:\n{}", bean1);
        PersonDomain bean2 = (PersonDomain) context.getBean("personName2");
        assertNotNull(bean2);
        logger.info("Spring容器 beanName[personName2] 获取bean:\n{}", bean2);
        PersonDomain bean3 = (PersonDomain) context.getBean("/personName3");
        assertNotNull(bean3);
        logger.info("Spring容器 beanName[/personName3] 获取bean:\n{}", bean3);
    }


    /**
     * Spring容器 通过 beanClass 获取 bean：
     * <br>当前Spring的配置文件中 只能有一个 bean class是Person类型 否则抛出异常
     */
    @DisplayName("Spring容器 通过 beanClass 获取 bean")
    @Test
    public void getBeanByClass() {
        try {
            PersonDomain bean = context.getBean(PersonDomain.class);
            assertNotNull(bean);
            logger.info("Spring容器 beanClass[Person.class] 获取bean:{}", bean);
        } catch (Exception e) {
            logger.error("Spring容器 beanClass[Person.class] 获取bean异常:", e);
            assertTrue(e instanceof NoUniqueBeanDefinitionException);
        }
    }


    /**
     * Spring容器 获取 所有bean标签的id值
     */
    @Test
    @DisplayName("Spring容器 获取 所有bean标签的id值")
    public void getBeanDefinitionNames() {
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            logger.info("getBeanDefinitionName is ==>{} |||| getBenan is ==>{}",
                    beanDefinitionName,
                    JsonUtils.toJson(context.getBean(beanDefinitionName)));
        }
    }


    /**
     * Spring容器 通过类型 获取 所有 id
     */
    @Test
    @DisplayName("Spring容器 通过类型 获取 所有 id")
    public void getBeanNamesForType() {
        String[] namesForType = context.getBeanNamesForType(PersonDomain.class);
        for (String beanNamesForType : namesForType) {
            logger.info("getBeanNamesForType===>{}", beanNamesForType);
        }
    }


    /**
     * Spring容器 通过 beanId,判断是否存在该 bean
     */
    @Test
    @DisplayName("Spring容器 通过 beanId,判断是否存在该 bean")
    public void containsBeanDefinition() {
        Assertions.assertTrue(context.containsBeanDefinition("person"));
        //不能判断name值
        Assertions.assertFalse(context.containsBeanDefinition("/personName3"));
    }

    /**
     * Spring容器 通过 beanId 或者 beanName,判断是否存在该bean
     */
    @Test
    @DisplayName("Spring容器 通过 beanId 或者 beanName,判断是否存在该bean")
    public void containsBean() {
        Assertions.assertTrue(context.containsBean("person"));
        //也可以判断name值
        Assertions.assertTrue(context.containsBean("personName1"));
    }


}
