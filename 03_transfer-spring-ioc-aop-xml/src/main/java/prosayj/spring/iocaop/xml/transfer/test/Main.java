package prosayj.spring.iocaop.xml.transfer.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import prosayj.spring.iocaop.xml.transfer.dao.impl.JdbcAccountDaoImpl;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-05-14 上午 11:15
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/applicationContext.xml");
        JdbcAccountDaoImpl bean = applicationContext.getBean(JdbcAccountDaoImpl.class);
        System.out.println(bean);
    }
}
