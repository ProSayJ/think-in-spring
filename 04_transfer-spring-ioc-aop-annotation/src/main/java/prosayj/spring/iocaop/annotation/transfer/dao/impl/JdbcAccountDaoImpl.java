package prosayj.spring.iocaop.annotation.transfer.dao.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import prosayj.spring.iocaop.annotation.transfer.dao.AccountDao;
import prosayj.spring.iocaop.annotation.transfer.pojo.Account;
import prosayj.spring.iocaop.annotation.transfer.utils.ConnectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@Repository
public class JdbcAccountDaoImpl implements AccountDao {
    @Autowired
    private ConnectionUtils connectionUtils;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String name;
    private int sex;
    private float money;
    //---------------------------------
    private String[] myArray;
    private Map<String, String> myMap;
    private Set<String> mySet;
    private Properties myProperties;


    public JdbcAccountDaoImpl() {
    }

    public JdbcAccountDaoImpl(ConnectionUtils connectionUtils, String name, int sex, float money) {
        this.connectionUtils = connectionUtils;
        this.name = name;
        this.sex = sex;
        this.money = money;
    }

    @PostConstruct
    public void init() {
        System.out.println("JdbcAccountDaoImpl 初始化方法.....");
    }

    @PreDestroy
    public void destory() {
        System.out.println("JdbcAccountDaoImpl 销毁方法......");
    }

    @Override
    public Account queryAccountByCardNo(String cardNo) throws Exception {
        String sql = "select * from account where cardNo=?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Account();
                account.setName(resultSet.getString("name"));
                account.setCardNo(resultSet.getString("cardNo"));
                account.setMoney(resultSet.getInt("money"));
                return account;
            }
        }, cardNo);
    }

    @Override
    public int updateAccountByCardNo(Account account) throws Exception {
        String sql = "update account set money=? where cardNo=?";
        return jdbcTemplate.update(sql,account.getMoney(),account.getCardNo());
    }
}
