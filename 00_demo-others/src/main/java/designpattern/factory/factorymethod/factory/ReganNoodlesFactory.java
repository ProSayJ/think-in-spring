package designpattern.factory.factorymethod.factory;


import designpattern.factory.factorymethod.NoodlesFactory;
import designpattern.factory.noodles.Noodles;
import designpattern.factory.noodles.ReganNoodles;

/**
 * 热干面工厂
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class ReganNoodlesFactory implements NoodlesFactory {
    @Override
    public Noodles createNoodles() {
        return new ReganNoodles();
    }
}
