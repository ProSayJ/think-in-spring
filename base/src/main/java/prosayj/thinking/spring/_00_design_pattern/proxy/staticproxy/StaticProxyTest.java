package prosayj.thinking.spring._00_design_pattern.proxy.staticproxy;


import prosayj.thinking.spring._00_design_pattern.proxy.service.RentingHouse;
import prosayj.thinking.spring._00_design_pattern.proxy.service.impl.RentingHouseImpl;
import org.junit.jupiter.api.Test;

public class StaticProxyTest {

    @Test
    public void m1() {
        RentingHouse rentingHouse = new RentingHouseImpl();
        // 自己要租用一个一室一厅的房子
        // rentingHouse.rentHosue();

        RentingHouseProxy rentingHouseProxy = new RentingHouseProxy(rentingHouse);
        rentingHouseProxy.rentHosue();
    }
}
