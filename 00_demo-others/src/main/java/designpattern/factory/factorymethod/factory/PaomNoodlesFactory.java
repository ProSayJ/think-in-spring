package designpattern.factory.factorymethod.factory;


import designpattern.factory.factorymethod.NoodlesFactory;
import designpattern.factory.noodles.Noodles;
import designpattern.factory.noodles.PaoNoodles;

/**
 * 泡面工厂
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class PaomNoodlesFactory implements NoodlesFactory {
    @Override
    public Noodles createNoodles() {
        return new PaoNoodles();
    }
}
