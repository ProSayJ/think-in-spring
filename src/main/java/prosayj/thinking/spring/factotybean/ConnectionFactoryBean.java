package prosayj.thinking.spring.factotybean;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ConnectionFactoryBean
 *
 * @author yangjian201127@credithc.com
 * @date 2021-01-02 下午 07:43
 * @since 1.0.0
 */
@Data
public class ConnectionFactoryBean implements FactoryBean<Connection> {
    /**
     * 将依赖的字符串信息变为成员变量, 利用配置文件进行注入
     */
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    /**
     * 用于书写创建复杂对象时的代码，并把复杂对象作为返回值对象返回
     *
     * @return Connection
     * @throws Exception Exception
     */
    @Override
    public Connection getObject() throws Exception {
        Class.forName(driverClassName);
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 返回创建的复杂对象的类型(class对象)
     *
     * @return Class<Connection>
     */
    @Override
    public Class<Connection> getObjectType() {
        return Connection.class;
    }

    /**
     * 是否单例
     *
     * @return false:每一次都创建新的复杂对象; true：只创建一次这种类型的复杂对象
     */
    @Override
    public boolean isSingleton() {
        return false;
        // return true;
    }
}
