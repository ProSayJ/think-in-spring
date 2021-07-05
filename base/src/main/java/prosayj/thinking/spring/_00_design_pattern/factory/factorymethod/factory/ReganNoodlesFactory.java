package prosayj.thinking.spring._00_design_pattern.factory.factorymethod.factory;


import prosayj.thinking.spring._00_design_pattern.factory.service.NoodlesService;
import prosayj.thinking.spring._00_design_pattern.factory.service.impl.ReganNoodlesServiceImpl;

/**
 * 热干面工厂
 *
 * @author yangjian
 */
public class ReganNoodlesFactory implements NoodlesFactory {
    @Override
    public NoodlesService createNoodles() {
        return new ReganNoodlesServiceImpl();
    }
}
