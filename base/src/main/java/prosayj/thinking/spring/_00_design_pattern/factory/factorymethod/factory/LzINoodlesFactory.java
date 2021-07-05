package prosayj.thinking.spring._00_design_pattern.factory.factorymethod.factory;


import prosayj.thinking.spring._00_design_pattern.factory.service.NoodlesService;
import prosayj.thinking.spring._00_design_pattern.factory.service.impl.LzNoodlesServiceImpl;

/**
 * 兰州拉面工厂
 *
 * @author yangjian
 */
public class LzINoodlesFactory implements NoodlesFactory {
    @Override
    public NoodlesService createNoodles() {
        return new LzNoodlesServiceImpl();
    }
}
