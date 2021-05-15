package prosayj.springiocxml.transfer.dao.impl;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;
import prosayj.springiocxml.transfer.dao.AccountDao;
import prosayj.springiocxml.transfer.pojo.Account;
import prosayj.springiocxml.transfer.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * JdbcAccountDaoImpl
 *
 * @author yangjian
 * @date 2021-05-13
 */
@Data
public class JdbcAccountDaoImpl implements AccountDao {
    private ConnectionUtils connectionUtils;
    private String name;
    private int sex;
    private float money;
    //---------------------------------
    private String[] myArray;
    private Map<String, String> myMap;
    private Set<String> mySet;
    private Properties myProperties;


    public JdbcAccountDaoImpl(ConnectionUtils connectionUtils, String name, int sex, float money) {
        this.connectionUtils = connectionUtils;
        this.name = name;
        this.sex = sex;
        this.money = money;
    }


    public void init() {
        System.out.println("初始化方法.....");
    }

    public void destory() {
        System.out.println("销毁方法......");
    }

    @Override
    public Account queryAccountByCardNo(String cardNo) throws Exception {
        //从连接池获取连接
        //Connection con = DruidUtils.getInstance().getConnection();
        Connection con = connectionUtils.getCurrentThreadConn();
        System.out.println("=======================con::::" + con);
        String sql = "select * from account where cardNo=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, cardNo);
        ResultSet resultSet = preparedStatement.executeQuery();
        Account account = new Account();
        while (resultSet.next()) {
            account.setCardNo(String.valueOf(resultSet.getLong("cardNo")));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getInt("money"));
        }

        resultSet.close();
        preparedStatement.close();
        if (account.getCardNo() == null) {
            return null;
        }
        //con.close();
        return account;
    }

    @Override
    public int updateAccountByCardNo(Account account) throws Exception {
        // 从连接池获取连接
        // 改造为：从当前线程当中获取绑定的connection连接
        //Connection con = DruidUtils.getInstance().getConnection();
        Connection con = connectionUtils.getCurrentThreadConn();
        String sql = "update account set money=? where cardNo=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, account.getMoney());
        preparedStatement.setString(2, account.getCardNo());
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        //con.close();
        return i;
    }
}
