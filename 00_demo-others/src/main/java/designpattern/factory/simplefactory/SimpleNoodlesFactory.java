package designpattern.factory.simplefactory;

import designpattern.factory.noodles.Noodles;
import designpattern.factory.noodles.LzNoodles;
import designpattern.factory.noodles.PaoNoodles;
import designpattern.factory.noodles.ReganNoodles;

/**
 * 简单工厂模式 一家“简单面馆”（简单工厂类）
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class SimpleNoodlesFactory {

    /**
     * 兰州拉面
     */
    public static final int TYPE_LZ = 1;
    /**
     * 泡面
     */
    public static final int TYPE_PM = 2;
    /**
     * 热干面
     */
    public static final int TYPE_GK = 3;

    /**
     * 如果生产对象的方法是static的，这种简单工厂也叫做静态工厂
     * 如果生产对象的方法不是static的，这种简单工厂也叫做实例工厂
     *
     * @param type type
     * @return Noodles
     */
    public static Noodles createNoodles(int type) {
        switch (type) {
            case 1:
                return new LzNoodles();
            case 2:
                return new PaoNoodles();
            case 3:
                return new ReganNoodles();
            default:
                return new LzNoodles();
        }
    }
}