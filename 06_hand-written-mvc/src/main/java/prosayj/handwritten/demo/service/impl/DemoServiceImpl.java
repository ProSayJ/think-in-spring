package prosayj.handwritten.demo.service.impl;

import prosayj.handwritten.demo.service.IDemoService;
import prosayj.handwritten.mvcframework.annotations.MyService;
/**
 * DemoServiceImpl
 *
 * @author yangjian
 * @date 2021-05-19
 */
@MyService("demoService")
public class DemoServiceImpl implements IDemoService {
    @Override
    public String get(String name) {
        System.out.println("service 实现类中的name参数：" + name) ;
        return name;
    }
}
