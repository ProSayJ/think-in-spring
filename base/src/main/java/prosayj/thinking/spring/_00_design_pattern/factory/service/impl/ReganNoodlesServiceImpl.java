package prosayj.thinking.spring._00_design_pattern.factory.service.impl;

import prosayj.thinking.spring._00_design_pattern.factory.service.NoodlesService;

/**
 * 热干面
 *
 * @author yangjian
 */
public class ReganNoodlesServiceImpl implements NoodlesService {
    @Override
    public void desc() {
        logger.info("红油热干面，武汉特色小吃");
    }
}
