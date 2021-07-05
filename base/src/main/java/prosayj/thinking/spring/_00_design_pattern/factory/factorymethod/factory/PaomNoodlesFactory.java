package prosayj.thinking.spring._00_design_pattern.factory.factorymethod.factory;


import prosayj.thinking.spring._00_design_pattern.factory.service.NoodlesService;
import prosayj.thinking.spring._00_design_pattern.factory.service.impl.PaoNoodlesServiceImpl;

/**
 * 泡面工厂
 *
 * @author yangjian
 */
public class PaomNoodlesFactory implements NoodlesFactory {
    @Override
    public NoodlesService createNoodles() {
        return new PaoNoodlesServiceImpl();
    }
}
