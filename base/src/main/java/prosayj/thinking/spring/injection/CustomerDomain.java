package prosayj.thinking.spring.injection;

import lombok.Data;

import java.util.*;

/**
 * Customer
 *
 * @author yangjian
 * @date 2021-01-01 下午 10:52
 * @since 1.0.0
 */
@Data
class CustomerDomain {
    private String name;
    private int age;
    private String[] emails;
    private Set<String> phones;
    private List<String> address;
    private Map<String, String> maps;
    private Properties properties;


    public CustomerDomain() {
    }

    public CustomerDomain(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public CustomerDomain(String name) {
        this.name = name;
    }

    public CustomerDomain(int age) {
        this.age = age;
    }
}
