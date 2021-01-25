package prosayj.thinking.spring.basic.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Person
 *
 * @author yangjian201127@credithc.com
 * @date 2020-12-26 下午 12:46
 * @since 1.0.0
 */
public class Person {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());
    private String pName;
    private int pAge;

    public Person() {
        logger.info(" Person Constractor invoke");
    }

    public Person(String pName, int pAge) {
        this.pName = pName;
        this.pAge = pAge;
    }

    public Person(String pName) {
        this.pName = pName;
    }

    public Person(int pAge) {
        this.pAge = pAge;
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
