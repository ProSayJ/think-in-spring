package prosayj.springtest.iocaop.service.impl;

import prosayj.springtest.iocaop.service.OrderService;
import prosayj.springtest.spring.Component;
import prosayj.springtest.spring.Scope;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-07-16 上午 08:58
 * @since 1.0.0
 */
@Scope("prototype")
@Component("orderService")
public class OrderServiceImpl implements OrderService {
}
