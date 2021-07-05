package prosayj.thinking.spring._00_design_pattern.factory.simplefactory;


import prosayj.thinking.spring._00_design_pattern.factory.service.impl.LzNoodlesServiceImpl;
import prosayj.thinking.spring._00_design_pattern.factory.service.impl.PaoNoodlesServiceImpl;
import prosayj.thinking.spring._00_design_pattern.factory.service.impl.ReganNoodlesServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * 简单工厂测试类
 * 简单工厂即：创建工厂的工厂
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class SimpleFactoryTest {

    /**
     * 一开始，穷，想吃面必须得自己做:
     * <p>想吃拉面得自己做，new LzNoodles() <br>
     * 想吃泡面得自己做，new PaoNoodles() <br>
     * 想吃热干面得自己做，new ReganNoodles() <br>
     * 然而，new来new去，改来改去，好心烦......
     */
    @Test
    public void m1() {
        // 做拉面吃
        new LzNoodlesServiceImpl().desc();
        // 做泡面吃
        new PaoNoodlesServiceImpl().desc();
        // 做热干面吃
        new ReganNoodlesServiceImpl().desc();
    }

    /**
     * 忽然，有一天走了狗屎运成了暴发户,幸福生活从此来临，吃面从此变得简单：
     * <p> 给面馆说一声想吃啥，面馆做好了给自己就好了 <br>
     * 自己不必关心面条怎么做（怎么new，如何new）让面馆操心去吧（面馆帮我们new）！ <br>
     * 好省心，有钱就是好，太爽了！ <br>
     * <p>考虑使用工厂模式： <br>
     * 1) 当客户程序不需要知道要使用对象的创建过程。 <br>
     * 2) 客户程序使用的对象存在变动的可能，或者根本就不知道使用哪一个具体的对象。 <br>
     */
    @Test
    public void m2() {
        // 和具体的对象脱离关系
        SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.NoodlesType.TYPE_GK)
                .desc();
    }
}
