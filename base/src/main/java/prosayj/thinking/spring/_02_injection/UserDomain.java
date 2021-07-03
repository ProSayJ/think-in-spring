package prosayj.thinking.spring._02_injection;

import lombok.Data;

/**
 * User
 *
 * @author yangjian
 * @date 2020-12-25 13:16
 * @since 1.0.0
 */
@Data
class UserDomain {
    private String name;
    private int age;

    public UserDomain(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
