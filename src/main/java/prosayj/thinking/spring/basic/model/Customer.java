package prosayj.thinking.spring.basic.model;

import lombok.Data;

import java.util.*;

/**
 * Customer
 *
 * @author yangjian201127@credithc.com
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
