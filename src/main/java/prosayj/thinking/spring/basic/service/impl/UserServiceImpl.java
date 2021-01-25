package prosayj.thinking.spring.basic.service.impl;

import prosayj.thinking.spring.basic.dao.UserDao;
import prosayj.thinking.spring.basic.service.UserService;

/**
 * UserServiceImpl
 *
 * @author yangjian201127@credithc.com
 * @date 2020-12-25 13:33
 * @since 1.0.0
 */
public class UserServiceImpl implements UserService {
    //private static final UserDao userDao = new UserDaoImpl();

    //private static final UserDao userDao = BeanFactory.getUserDao();

    //private static final UserDao userDao = (UserDao) CustomerBeanFactory.getBean("userDao");

    private UserDao userDao;

    @Override
    public void createUser(String userName, int age) {
        userDao.createUser(userName, age);
    }

    @Override
    public void login(String userName, String pwd) {
        userDao.login(userName, pwd);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
