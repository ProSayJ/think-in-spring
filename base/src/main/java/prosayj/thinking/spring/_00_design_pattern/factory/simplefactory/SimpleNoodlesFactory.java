package prosayj.thinking.spring._00_design_pattern.factory.simplefactory;


import prosayj.thinking.spring._00_design_pattern.factory.service.NoodlesService;
import prosayj.thinking.spring._00_design_pattern.factory.service.impl.LzNoodlesServiceImpl;
import prosayj.thinking.spring._00_design_pattern.factory.service.impl.PaoNoodlesServiceImpl;
import prosayj.thinking.spring._00_design_pattern.factory.service.impl.ReganNoodlesServiceImpl;

/**
 * 简单工厂模式 一家“简单面馆”（简单工厂类）
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class SimpleNoodlesFactory {


    /**
     * 如果生产对象的方法是static的，这种简单工厂也叫做静态工厂
     * 如果生产对象的方法不是static的，这种简单工厂也叫做实例工厂
     *
     * @param type type
     * @return Noodles
     */
    public static NoodlesService createNoodles(NoodlesType type) {
        switch (type) {
            case TYPE_LZ:
                return new LzNoodlesServiceImpl();
            case TYPE_PM:
                return new PaoNoodlesServiceImpl();
            case TYPE_GK:
                return new ReganNoodlesServiceImpl();
            default:
                return new LzNoodlesServiceImpl();
        }
    }

    enum NoodlesType {
        /**
         * 兰州拉面
         */
        TYPE_LZ,
        /**
         * 泡面
         */
        TYPE_PM,
        /**
         * 热干面
         */
        TYPE_GK
    }
}