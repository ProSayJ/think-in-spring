package iocaop;


import iocaop.config.AppConfig;
import iocaop.service.OrderService;
import iocaop.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author yangjian
 * @since 1.0.0 <br>2021-07-16 上午 08:36
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = applicationContext.getBean(OrderService.class);
        System.out.println(orderService);

        UserService userService = applicationContext.getBean(UserService.class);
        System.out.println(userService);
        userService.test();

    }
}
