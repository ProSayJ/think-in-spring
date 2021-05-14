package designpattern.factory.factorymethod;


import designpattern.factory.factorymethod.factory.LzINoodlesFactory;
import designpattern.factory.noodles.Noodles;

/**
 * 工厂方法测试类
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class Main {
    public static void main(String[] args) {
        NoodlesFactory noodlesFactory = new LzINoodlesFactory();
        Noodles noodles = noodlesFactory.createNoodles();
        noodles.desc();
    }
}
