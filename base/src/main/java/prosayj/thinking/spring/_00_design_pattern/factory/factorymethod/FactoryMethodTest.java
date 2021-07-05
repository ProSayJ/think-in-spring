package prosayj.thinking.spring._00_design_pattern.factory.factorymethod;


import prosayj.thinking.spring._00_design_pattern.factory.factorymethod.factory.LzINoodlesFactory;
import org.junit.jupiter.api.Test;

/**
 * 工厂方法测试类
 *
 * @author yangjian
 */
public class FactoryMethodTest {
    @Test
    public  void m1() {
       new LzINoodlesFactory()
               .createNoodles()
               .desc();
    }
}
