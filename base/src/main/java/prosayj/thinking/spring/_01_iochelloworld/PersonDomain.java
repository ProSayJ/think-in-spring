package prosayj.thinking.spring._01_iochelloworld;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Person
 *
 * @author yangjian
 * @date 2020-12-26 下午 12:46
 * @since 1.0.0
 */
@Data
class PersonDomain {
    @JsonIgnore
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String pName;
    private int pAge;

    public PersonDomain() {
        logger.info(" Person 无参构造方法 被调用");
    }

}
