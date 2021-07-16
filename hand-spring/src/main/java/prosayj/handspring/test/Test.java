package prosayj.handspring.test;

import prosayj.handspring.spring.AnnotationConfigApplicationContext;
import prosayj.handspring.test.config.AppConfig;
import prosayj.handspring.test.service.OrderService;
import prosayj.handspring.test.service.UserService;

/**
 * TODO
 *
 * @author yangjian
 * @since 1.0.0 <br>2021-07-16 上午 08:36
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        System.out.println(orderService);

        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService);
        userService.test();

    }
}
