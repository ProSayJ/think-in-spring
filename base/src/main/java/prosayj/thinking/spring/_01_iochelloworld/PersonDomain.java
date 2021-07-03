package prosayj.thinking.spring._01_iochelloworld;

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

    public PersonDomain(String pName, int pAge) {
        this.pName = pName;
        this.pAge = pAge;
        logger.info(" Person 有参构造方法[pName,pAge] 被调用");
    }

    public PersonDomain(String pName) {
        this.pName = pName;
        logger.info(" Person 有参构造方法[pName] 被调用");
    }

    public PersonDomain(int pAge) {
        this.pAge = pAge;
        logger.info(" Person 有参构造方法[pAge] 被调用");
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpAge() {
        return pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pName='" + pName + '\'' +
                ", pAge=" + pAge +
                '}';
    }
}
