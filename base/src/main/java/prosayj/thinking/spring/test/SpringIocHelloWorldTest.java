package prosayj.thinking.spring.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import prosayj.thinking.spring.beanfactory.CustomerBeanFactory;
import prosayj.thinking.spring.common.support.model.Person;
import prosayj.thinking.spring.common.support.service.UserService;
import prosayj.thinking.spring.common.support.service.impl.UserServiceImpl;
import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;
import prosayj.thinking.spring.common.support.util.JsonUtils;


import static org.junit.jupiter.api.Assertions.*;

/**
 * SpringIocHelloWorldTest
 *
 * @author yangjian
 * @date 2020-12-25 13:41
 * @since 1.0.0
 */
public class SpringIocHelloWorldTest extends ClasspathContextSetEnv {

    public SpringIocHelloWorldTest() {
        super("test/SpringIocHelloWorldTest.xml");
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
    }

    /**
     * Spring容器 通过 benaId 获取 bean
     */
    @DisplayName("Spring容器 通过 benaId 获取 bean")
    @Test
    public void getBeanById() {
        Person bean = (Person) context.getBean("person1");
        assertNotNull(bean);
        logger.info("Spring容器 id 获取bean:\n{}", bean);
    }

    /**
     * Spring容器 通过 benaName 获取 bean
     */
    @DisplayName("Spring容器 通过 benaName 获取 bean")
    @Test
    public void getBeanByName() {
        Person bean1 = (Person) context.getBean("personName1");
        assertNotNull(bean1);
        logger.info("Spring容器 beanName[personName1] 获取bean:\n{}", bean1);
        Person bean2 = (Person) context.getBean("personName2");
        assertNotNull(bean2);
        logger.info("Spring容器 beanName[personName2] 获取bean:\n{}", bean2);
        Person bean3 = (Person) context.getBean("/personName3");
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
            Person bean = context.getBean(Person.class);
            assertNotNull(bean);
            logger.info("Spring容器 beanClass[Person.class] 获取bean:\n{}", bean);
        } catch (Exception e) {
            logger.error("Spring容器 beanClass[Person.class] 获取bean异常:", e);
            assertTrue(e instanceof NoUniqueBeanDefinitionException);
        }
    }

    /**
     * Spring容器 通过 beanId+beanClass 获取bean
     */
    @Test
    @DisplayName("Spring容器 通过 beanId+beanClass 获取bean")
    public void getBeanByIdAndClass() {
        Person bean = context.getBean("person1", Person.class);
        assertNotNull(bean);
        logger.info("Spring容器 beanId + beanClass 获取bean:\n{}", bean);
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
        for (String beanNamesForType : context.getBeanNamesForType(Person.class)) {
            logger.info("getBeanNamesForType===>{}", beanNamesForType);
        }
    }


    /**
     * Spring容器 通过 beanId,判断是否存在该 bean
     */
    @Test
    @DisplayName("Spring容器 通过 beanId,判断是否存在该 bean")
    public void containsBeanDefinition() {
        Assertions.assertTrue(context.containsBeanDefinition("person1"));
        //不能判断name值
        Assertions.assertFalse(context.containsBeanDefinition("/personName3"));
    }

    /**
     * Spring容器 通过 beanId 或者 beanName,判断是否存在该bean
     */
    @Test
    @DisplayName("Spring容器 通过 beanId 或者 beanName,判断是否存在该bean")
    public void containsBean() {
        Assertions.assertTrue(context.containsBean("person1"));
        //也可以判断name值
        Assertions.assertTrue(context.containsBean("personName1"));
    }

}
