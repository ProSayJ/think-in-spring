package prosayj.thinking.spring.basic.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import prosayj.thinking.spring.basic.dao.UserDao;

/**
 * UserDaoImpl
 *
 * @author yangjian201127@credithc.com
 * @date 2020-12-25 13:34
 * @since 1.0.0
 */
public class UserDaoImpl implements UserDao {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void createUser(String userName, int age) {
        logger.info("user：【{}】，【{}】 created", userName, age);
    }

    @Override
    public void login(String userName, String pwd) {
        logger.info("{}  login success password is {}", userName, pwd);
    }
}
