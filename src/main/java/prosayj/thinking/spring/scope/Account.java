package prosayj.thinking.spring.scope;

import lombok.Data;

import java.util.Date;

/**
 * Account
 *
 * @author yangjian201127@credithc.com
 * @date 2021-01-02 下午 09:07
 * @since 1.0.0
 */
public class Account{
    private String owner;
    private Date createTime;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "owner='" + owner + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
