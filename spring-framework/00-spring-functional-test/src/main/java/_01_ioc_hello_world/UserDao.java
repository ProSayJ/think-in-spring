package _01_ioc_hello_world;

/**
 * UserDao
 *
 * @author yangjian
 * @date 2020-12-25 13:34
 * @since 1.0.0
 */
interface UserDao {
    void createUser(String userName, int age);

    void login(String userName, String pwd);
}
