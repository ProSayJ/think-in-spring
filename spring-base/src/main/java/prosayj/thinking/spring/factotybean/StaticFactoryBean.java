package prosayj.thinking.spring.factotybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * StaticFactoryBean
 *
 * @author yangjian
 * @date 2021-01-02 下午 08:58
 * @since 1.0.0
 */
public class StaticFactoryBean {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=Hongkong&useSSL=false", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
