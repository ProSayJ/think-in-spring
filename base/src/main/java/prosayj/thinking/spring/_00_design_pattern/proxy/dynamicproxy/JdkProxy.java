package prosayj.thinking.spring._00_design_pattern.proxy.dynamicproxy;

import prosayj.thinking.spring._00_design_pattern.proxy.service.RentingHouse;
import prosayj.thinking.spring._00_design_pattern.proxy.service.impl.RentingHouseImpl;

/**
 * @author yangjian
 */
public class JdkProxy {

    public static void main(String[] args) {

        RentingHouse rentingHouse = new RentingHouseImpl();  // 委托对象---委托方

        // 从代理对象工厂获取代理对象
        RentingHouse jdkProxy = (RentingHouse) ProxyFactory.getInstance().getJdkProxy(rentingHouse);

        jdkProxy.rentHosue();


    }
}
