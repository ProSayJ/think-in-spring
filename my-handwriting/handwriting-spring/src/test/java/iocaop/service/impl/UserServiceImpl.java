package iocaop.service.impl;


import iocaop.service.OrderService;
import iocaop.service.UserService;
import prosayj.handwritingspring.spring.Autowired;
import prosayj.handwritingspring.spring.BeanNameAware;
import prosayj.handwritingspring.spring.Component;
import prosayj.handwritingspring.spring.InitializingBean;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-07-16 上午 08:58
 * @since 1.0.0
 */
//@Scope("prototype")
@Component("userService")
public class UserServiceImpl implements UserService, BeanNameAware, InitializingBean {

    @Autowired
    private OrderService orderService;



    /**
     * 获取当前Bean对象的名称
     */
    private String beanName;

    @Override
    public void test() {
        System.out.println("UserService#test:invoke get orderService--->" + orderService);
        System.out.println("UserService#test:invoke get beanName--->" + beanName);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //
        System.out.println("UserService afterPropertiesSet invoke");
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public String getBeanName() {
        return beanName;
    }
}
