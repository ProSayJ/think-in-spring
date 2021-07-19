package prosayj.transfer.utils;

import prosayj.handwriting.spring.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库链接对象
 *
 * @author yangjian
 * @date 2021-05-13
 */
@Component("connectionUtils")
public class ConnectionUtils {

    /**
     * 存储当前线程的连接
     */
    private final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();


    /**
     * 从当前线程获取连接
     */
    public Connection getCurrentThreadConn() throws SQLException {
        //判断当前线程中是否已经绑定连接，如果没有绑定，需要从连接池获取一个连接绑定到当前线程
        Connection connection = THREAD_LOCAL.get();
        if (connection == null) {
            // 从连接池拿连接并绑定到线程
            connection = DruidUtils.getInstance().getConnection();
            // 绑定到当前线程
            THREAD_LOCAL.set(connection);
        }
        return connection;
    }

    /**
     * 从当前线移除取连接
     */
    public void removeConnection() throws SQLException {
        //判断当前线程中是否已经绑定连接，如果没有绑定，需要从连接池获取一个连接绑定到当前线程
        Connection connection = THREAD_LOCAL.get();
        if (connection != null) {
            // 绑定到当前线程
            THREAD_LOCAL.remove();
        }
    }


}
