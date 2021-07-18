package iocaop.config;


import org.springframework.context.annotation.ComponentScan;

/**
 * TODO
 *
 * @author yangjian
 * @since 1.0.0 <br>2021-07-16 上午 08:41
 */
@ComponentScan("iocaop.service")
public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig-----init");
    }
}

