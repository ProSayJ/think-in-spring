package prosayj.thinking.spring.iochelloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UserDaoImpl
 *
 * @author yangjian
 * @date 2020-12-25 13:34
 * @since 1.0.0
 */
public class UserDaoImpl implements UserDao {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void createUser(String userName, int age) {
        logger.info("createUser,userInfo===>：【{}】，【{}】 created", userName, age);
    }

    @Override
    public void login(String userName, String pwd) {
        logger.info("login====> {}  login success password is {}", userName, pwd);
    }
}
