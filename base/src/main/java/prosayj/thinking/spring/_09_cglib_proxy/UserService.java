package prosayj.thinking.spring._09_cglib_proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UserServiceImpl
 *
 * @author yangjian
 * @date 2020-12-25 13:33
 * @since 1.0.0
 */
class UserService {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void createUser(String userName, int age) {
        logger.info("createUser,userInfo===>：【{}】，【{}】 created", userName, age);
    }

    public void login(String userName, String pwd) {
        logger.info("login====> {}  login success password is {}", userName, pwd);
    }
}
