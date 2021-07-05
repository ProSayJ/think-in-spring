package prosayj.thinking.spring._00_design_pattern.factory.service.impl;

import prosayj.thinking.spring._00_design_pattern.factory.service.NoodlesService;

/**
 * 泡面
 *
 * @author yangjian
 */
public class PaoNoodlesServiceImpl implements NoodlesService {
    @Override
    public void desc() {
        logger.info("泡面，程序员必备");
    }
}
