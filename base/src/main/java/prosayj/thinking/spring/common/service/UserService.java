package prosayj.thinking.spring.common.service;

/**
 * UserService
 *
 * @author yangjian
 * @date 2020-12-25 13:33
 * @since 1.0.0
 */
public interface UserService {

    void createUser(String userName, int age);

    void login(String userName, String pwd);
}
