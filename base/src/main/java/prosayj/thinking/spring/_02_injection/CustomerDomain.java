package prosayj.thinking.spring._02_injection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    @JsonIgnore
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String name;
    private int age;
    private String[] emails;
    private List<String> address;
    private Set<String> phones;
    private Map<String, String> maps;
    private Properties properties;


    public CustomerDomain() {
        logger.info(" CustomerDomain 无参构造方法 被调用");
    }

    public CustomerDomain(String name, int age) {
        this.name = name;
        this.age = age;
        logger.info(" CustomerDomain 有参构造方法[name,age] 被调用");
    }

    public CustomerDomain(String name) {
        this.name = name;
        logger.info(" CustomerDomain 有参构造方法[name] 被调用");
    }

    public CustomerDomain(int age) {
        this.age = age;
        logger.info(" CustomerDomain 有参构造方法[age] 被调用");
    }
}
