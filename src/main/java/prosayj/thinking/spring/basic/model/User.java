package prosayj.thinking.spring.basic.model;

import lombok.Data;

/**
 * User
 *
 * @author yangjian201127@credithc.com
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
