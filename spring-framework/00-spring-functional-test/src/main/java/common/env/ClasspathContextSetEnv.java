package common.env;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * BaseEnv
 *
 * @author yangjian
 * @date 2021-01-02 上午 12:17
 * @since 1.0.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClasspathContextSetEnv {
    public final Logger logger = LoggerFactory.getLogger(getClass());
    public ApplicationContext context = null;
    public String contextPath;

    public ClasspathContextSetEnv() {
    }

    public ClasspathContextSetEnv(String contextPath) {
        this.contextPath = contextPath;
    }

    @BeforeAll
    public void initContext() {
        //获取spring的工厂
        //context = new ClassPathXmlApplicationContext("/05_ConfigurationParameterizationTest.xml");
        context = new ClassPathXmlApplicationContext(contextPath);
    }

    @AfterAll
    public void distoryContext() {
        if (context != null && context instanceof ClassPathXmlApplicationContext) {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }

}
