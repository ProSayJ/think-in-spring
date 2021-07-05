package prosayj.thinking.spring._01_ioc_hello_world;

/**
 * UserServiceImpl
 *
 * @author yangjian
 * @date 2020-12-25 13:33
 * @since 1.0.0
 */
class UserServiceImpl implements UserService {
    //private static final UserDao userDao = new UserDaoImpl();
    //private static final UserDao userDao = BeanFactory.getUserDao();
    //private UserDao userDao = (UserDao) CustomerBeanFactory.getBean("userDao");
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
