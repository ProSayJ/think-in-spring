package prosayj.thinking.spring._00_design_pattern.proxy.service.impl;

import prosayj.thinking.spring._00_design_pattern.proxy.service.RentingHouse;


public class RentingHouseImpl implements RentingHouse {
    @Override
    public void rentHosue() {
        logger.info("我要租用一室一厅的房子");
    }
}