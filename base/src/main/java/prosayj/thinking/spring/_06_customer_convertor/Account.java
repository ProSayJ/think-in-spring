package prosayj.thinking.spring._06_customer_convertor;

import lombok.Data;

import java.util.Date;

/**
 * Account
 *
 * @author yangjian
 * @date 2021-01-02 下午 09:07
 * @since 1.0.0
 */
@Data
class Account {
    private String owner;
    private Date createTime;
    private Date updateTime;
}
