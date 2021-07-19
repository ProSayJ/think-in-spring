package prosayj.handwritten.transfer.tx;

import prosayj.handwritten.transfer.utils.ConnectionUtils;

import java.sql.SQLException;

/**
 * 事务管理器类：负责手动事务的开启、提交、回滚
 *
 * @author yangjian
 * @date 2021-05-13
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public ConnectionUtils getConnectionUtils() {
        return connectionUtils;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启手动事务控制
     *
     * @throws SQLException SQLException
     */
    public void beginTransaction() throws SQLException {
        connectionUtils.getCurrentThreadConn().setAutoCommit(false);
        System.out.println("业务事务开始，关闭自动提交事务");
    }


    /**
     * 提交事务
     *
     * @throws SQLException SQLException
     */
    public void commit() throws SQLException {
        connectionUtils.getCurrentThreadConn().commit();
        System.out.println("业务事务结束，手动提交事务，成功");
    }


    /**
     * 回滚事务
     *
     * @throws SQLException SQLException
     */
    public void rollback() throws SQLException {
        connectionUtils.getCurrentThreadConn().rollback();
        connectionUtils.removeConnection();
        System.out.println("业务事务异常，手动回滚事务，成功");
    }
}
