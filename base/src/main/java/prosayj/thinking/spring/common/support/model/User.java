package prosayj.thinking.spring.common.support.model;

import lombok.Data;

/**
 * User
 *
 * @author yangjian
 * @date 2020-12-25 13:16
 * @since 1.0.0
 */
@Data
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
