package iocaop;

import iocaop.config.AppConfig;
import iocaop.service.OrderService;
import iocaop.service.UserService;
import prosayj.handwriting.spring.AnnotationConfigApplicationContext;

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
