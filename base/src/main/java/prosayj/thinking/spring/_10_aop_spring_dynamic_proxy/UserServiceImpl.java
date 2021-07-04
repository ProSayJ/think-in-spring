package prosayj.thinking.spring._10_aop_spring_dynamic_proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UserServiceImpl
 *
 * @author yangjian
 * @date 2020-12-25 13:33
 * @since 1.0.0
 */
class UserServiceImpl implements UserService {
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
