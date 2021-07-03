package prosayj.thinking.spring.common.support.model;

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
public class Customer {
    private String name;
    private int age;
    private String[] emails;
    private Set<String> phones;
    private List<String> address;
    private Map<String, String> maps;
    private Properties properties;

}
