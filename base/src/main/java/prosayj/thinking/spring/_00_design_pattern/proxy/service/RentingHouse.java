package prosayj.thinking.spring._00_design_pattern.proxy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 接口：租房
 * jdk动态代理/cglib动态代理
 */
public interface RentingHouse {
    Logger logger = LoggerFactory.getLogger(RentingHouse.class);

    void rentHosue();
}