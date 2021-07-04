package prosayj.thinking.spring._07_static_proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 手动实现静态代理：
 * <p>代理类 = 目标类(原始类) + 额外功能 + 原始类(目标类)实现相同的接口
 * <p>动态代理的问题：
 * <br>1:静态类文件数量过多，不利于项目管理
 * <br>2:额外功能维护性差:代理类中 额外功能修改复杂(麻烦)
 *
 * @author yangjian
 * @date 2021-01-31 下午 10:26
 * @since 1.0.0
 */
class UserServiceProxy implements UserService {
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
