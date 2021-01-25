package prosayj.thinking.spring.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;

/**
 * BaseEnv
 *
 * @author yangjian201127@credithc.com
 * @date 2021-01-02 上午 12:17
 * @since 1.0.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(locations = {
        "classpath:applicationContext.xml"})
public class BaseEnv {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());
    public ApplicationContext context = null;
    public List<String> asList = null;

    @BeforeAll
    public void initContext() {
        //获取spring的工厂
        context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        asList = Arrays.asList("person",
                "person1",
                "/person",
                "person2",
                "person3",
                "prosayj.thinking.spring.basic.model.Person#0",
                "prosayj.thinking.spring.basic.model.Person#1",
                "pname",
                "pppp",
                "/pppp",
                "customer",
                "userDao",
                "userService",
                "org.springframework.context.support.PropertySourcesPlaceholderConfigurer#0",
                "conn",
                "connFactory",
                "conn2",
                "conn3",
                "myDateConverter",
                "conversionService",
                "scopeSingleton",
                "scopePrototype",
                "product",
                "categroy",
                "myBeanPostProcessor"
        );
    }

    @AfterAll
    public void distoryContext() {
        if (context != null) {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }

}
