package common.env;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * TODO
 *
 * @author yangjian
 * @since 1.0.0 <br>  2021-07-20 上午 09:54
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AnnotationContextSetEnv {
    public final Logger logger = LoggerFactory.getLogger(getClass());
    public ApplicationContext context = null;
    public Class<?> aClass;

    @BeforeAll
    public void init() {
        assertNotNull(aClass, "配置类为空");
        context = new AnnotationConfigApplicationContext(aClass);
    }

    public AnnotationContextSetEnv(Class<?> aClass) {
        this.aClass = aClass;
    }

    @AfterAll
    public void distoryContext() {
        if (context != null && context instanceof ClassPathXmlApplicationContext) {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }
}
