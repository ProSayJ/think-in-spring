package prosayj.springiocannotation.transfer.utils;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * alibaba 数据库连接池
 *
 * @author yangjian
 * @date 2021-05-13
 */
public class DruidUtils {

    private DruidUtils() {
    }

    private static final DruidDataSource DRUID_DATA_SOURCE = new DruidDataSource();

    static {
        DRUID_DATA_SOURCE.setDriverClassName("com.mysql.cj.jdbc.Driver");
        DRUID_DATA_SOURCE.setUrl("jdbc:mysql://localhost:3306/spring?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=false&characterEncoding=utf-8");
        DRUID_DATA_SOURCE.setUsername("root");
        DRUID_DATA_SOURCE.setPassword("root");
    }

    public static DruidDataSource getInstance() {
        return DRUID_DATA_SOURCE;
    }

}
