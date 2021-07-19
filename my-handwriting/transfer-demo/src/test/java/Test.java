import prosayj.handwriting.spring.AnnotationConfigApplicationContext;
import prosayj.transfer.config.AppConfig;

/**
 * TODO
 *
 * @author yangjian201127@credithc.com
 * @since 1.0.0 <br>  2021-07-19 下午 04:11
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(applicationContext.getBean("transferService"));
    }
}
