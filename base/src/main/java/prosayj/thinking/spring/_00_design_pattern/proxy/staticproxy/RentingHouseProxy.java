package prosayj.thinking.spring._00_design_pattern.proxy.staticproxy;


import prosayj.thinking.spring._00_design_pattern.proxy.service.RentingHouse;

public class RentingHouseProxy implements RentingHouse {
    private final RentingHouse rentingHouse;

    public RentingHouseProxy(RentingHouse rentingHouse) {
        this.rentingHouse = rentingHouse;
    }

    @Override
    public void rentHosue() {
        logger.info("中介（代理）收取服务费3000元");
        rentingHouse.rentHosue();
        logger.info("客户信息卖了3毛钱");
    }
}