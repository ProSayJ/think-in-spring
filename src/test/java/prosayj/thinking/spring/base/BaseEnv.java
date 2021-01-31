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

    @BeforeAll
    public void initContext() {
        //获取spring的工厂
        context = new ClassPathXmlApplicationContext("/applicationContext.xml");
    }

    @AfterAll
    public void distoryContext() {
        if (context != null && context instanceof ClassPathXmlApplicationContext) {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }

}
