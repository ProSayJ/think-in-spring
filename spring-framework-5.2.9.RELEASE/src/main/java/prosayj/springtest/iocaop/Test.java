package prosayj.springtest.iocaop;

import prosayj.springtest.spring.AnnotationConfigApplicationContext;
import prosayj.springtest.iocaop.config.AppConfig;
import prosayj.springtest.iocaop.service.OrderService;
import prosayj.springtest.iocaop.service.UserService;

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
