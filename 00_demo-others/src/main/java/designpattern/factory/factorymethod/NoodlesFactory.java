package designpattern.factory.factorymethod;


import designpattern.factory.noodles.Noodles;

/**
 * 工厂方法模式
 *
 * @author yangjian
 * @date 2021-05-14
 */
public interface NoodlesFactory {
    Noodles createNoodles();
}