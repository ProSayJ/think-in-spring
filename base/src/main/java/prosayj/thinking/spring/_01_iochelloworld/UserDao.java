package prosayj.thinking.spring._01_iochelloworld;

/**
 * UserDao
 *
 * @author yangjian
 * @date 2020-12-25 13:34
 * @since 1.0.0
 */
public interface UserDao {
    void createUser(String userName, int age);

    void login(String userName, String pwd);
}
