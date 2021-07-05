package prosayj.thinking.spring._00_design_pattern.proxy.dynamicproxy;


import prosayj.thinking.spring._00_design_pattern.proxy.service.impl.RentingHouseImpl;

/**
 * @author yangjian
 */
public class CglibProxy {

    public static void main(String[] args) {
        RentingHouseImpl rentingHouse = new RentingHouseImpl();  // 委托对象

        // 获取rentingHouse对象的代理对象，
        // Enhancer类似于JDK动态代理中的Proxy
        // 通过实现接口MethodInterceptor能够对各个方法进行拦截增强，类似于JDK动态代理中的InvocationHandler

        // 使用工厂来获取代理对象
        RentingHouseImpl cglibProxy = (RentingHouseImpl) ProxyFactory.getInstance().getCglibProxy(rentingHouse);

        cglibProxy.rentHosue();
    }
}
