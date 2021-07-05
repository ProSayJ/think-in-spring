package prosayj.thinking.spring._11_spring_tx;

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
