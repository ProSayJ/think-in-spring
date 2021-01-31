package prosayj.thinking.spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import prosayj.thinking.spring.base.BaseEnv;
import prosayj.thinking.spring.beanfactory.CustomerBeanFactory;
import prosayj.thinking.spring.basic.model.Person;
import prosayj.thinking.spring.basic.service.UserService;
import prosayj.thinking.spring.basic.service.impl.UserServiceImpl;


import static org.junit.jupiter.api.Assertions.*;

/**
 * UserTest
 *
 * @author yangjian201127@credithc.com
 * @date 2020-12-25 13:41
 * @since 1.0.0
 */
public class _01_ApplicationContextTest extends BaseEnv {
    @Test
    @DisplayName("00-手动创建bean对象")
    public void createBean() {
        new UserServiceImpl();
    }


    @Test
    @DisplayName("01-自定义工厂创建对象")
    public void customerBeanFactoryGetBean() {
        assertNotNull(CustomerBeanFactory.getUserService());
        UserService userService = (UserService) CustomerBeanFactory.getBean("userService");
        assertNotNull(userService);
    }

    @Test
    @DisplayName("02-Spring通过 benaId 获取bean")
    public void getBeanById() {
        Person bean = (Person) context.getBean("person");
        assertNotNull(bean);
        logger.info("通过 id 获取bean:\n{}", bean);
        bean.setpName("张三");
        bean.setpAge(23);
        logger.info("通过 id 获取bean:\n{}", bean);
    }

    @Test
    @DisplayName("03-Spring通过 beanClass 获取bean")
    //当前Spring的配置文件中 只能有一个 bean class是Person类型 否则抛出异常
    public void getBeanByClass() {
        try {
            Person bean = context.getBean(Person.class);
            assertNotNull(bean);
            logger.info("通过 beanClass 获取bean:\n{}", bean);
        } catch (Exception e) {
            logger.error("通过 beanClass 获取bean异常:", e);
            assertTrue(e instanceof NoUniqueBeanDefinitionException);
        }
    }

    @Test
    @DisplayName("04-Spring通过 beanId+beanClass 获取bean")
    public void getBeanByIdAndClass() {
        Person bean = context.getBean("person", Person.class);
        assertNotNull(bean);
        logger.info("通过 beanId + beanClass 获取bean:\n{}", bean);
    }

    @Test
    @DisplayName("05-获取Spring容器中 所有bean标签的id值")
    public void getBeanDefinitionNames() {
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            logger.info("getBeanDefinitionName is==>{}", beanDefinitionName);
        }
    }

    @Test
    @DisplayName("06-根据类型获得获取Spring容器中 对应的id值")
    public void getBeanNamesForType() {
        for (String beanNamesForType : context.getBeanNamesForType(Person.class)) {
            logger.info("getBeanNamesForType===>{}", beanNamesForType);
        }
    }


    @Test
    @DisplayName("07-containsBeanDefinition:通过beanId,判断是否存在该bean")
    public void containsBeanDefinition() {
        assertTrue(context.containsBeanDefinition("person"));
        //不能判断name值
        assertFalse(context.containsBeanDefinition("/pppp"));
    }

    @Test
    @DisplayName("08-containsBean：通过beanId或者beanName,判断是否存在该bean")
    public void containsBean() {
        assertTrue(context.containsBean("pname"));
        //也可以判断name值
        assertTrue(context.containsBean("/pppp"));
    }

}
