package prosayj.thinking.spring._01_ioc_hello_world;

/**
 * UserService
 *
 * @author yangjian
 * @date 2020-12-25 13:33
 * @since 1.0.0
 */
interface UserService {

    void createUser(String userName, int age);

    void login(String userName, String pwd);
}
