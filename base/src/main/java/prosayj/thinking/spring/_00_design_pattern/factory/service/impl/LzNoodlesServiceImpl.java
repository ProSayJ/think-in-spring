package prosayj.thinking.spring._00_design_pattern.factory.service.impl;

import prosayj.thinking.spring._00_design_pattern.factory.service.NoodlesService;

/**
 * 兰州拉面
 *
 * @author yangjian
 */
public class LzNoodlesServiceImpl implements NoodlesService {
    @Override
    public void desc() {
        logger.info("兰州拉面，兰州特色小吃");
    }
}
