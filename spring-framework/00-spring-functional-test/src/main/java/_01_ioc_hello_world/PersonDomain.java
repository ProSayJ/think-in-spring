package _01_ioc_hello_world;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Person
 *
 * @author yangjian
 * @date 2020-12-26 下午 12:46
 * @since 1.0.0
 */
class PersonDomain {
    @JsonIgnore
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String pName;
    private int pAge;

    public PersonDomain() {
        logger.info(" Person 无参构造方法 被调用");
    }

}
