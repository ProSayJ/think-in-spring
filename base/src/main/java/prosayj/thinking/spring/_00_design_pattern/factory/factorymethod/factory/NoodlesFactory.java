package prosayj.thinking.spring._00_design_pattern.factory.factorymethod.factory;


import prosayj.thinking.spring._00_design_pattern.factory.service.NoodlesService;

/**
 * 工厂方法模式
 *
 * @author yangjian
 */
public interface NoodlesFactory {

    NoodlesService createNoodles();
}