package prosayj.thinking.spring._02_inverseofcontroller;

import lombok.Data;

import java.util.Date;

/**
 * User
 *
 * @author yangjian
 * @date 2020-12-25 13:16
 * @since 1.0.0
 */
@Data
class UserDomain {
    private String name;
    private int age;
    private Date createTime;
    private Date updateTime;


}
