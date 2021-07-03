package prosayj.thinking.spring.proxy.staticproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import prosayj.thinking.spring.common.support.service.UserService;
import prosayj.thinking.spring.common.support.service.impl.UserServiceImpl;

/**
 * UserServiceProxy
 *
 * @author yangjian
 * @date 2021-01-31 下午 10:26
 * @since 1.0.0
 */
public class UserServiceProxy implements UserService {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 代理类中必须有原始类
     */
    private final UserService userService = new UserServiceImpl();

    @Override
    public void createUser(String userName, int age) {
        // 额外功能
        logger.info("UserServiceProxy.createUser log~~~");
        userService.createUser(userName, age);

    }

    @Override
    public void login(String userName, String pwd) {
        // 额外功能
        logger.info("UserServiceProxy.login log~~~");
        userService.login(userName, pwd);
    }
}
