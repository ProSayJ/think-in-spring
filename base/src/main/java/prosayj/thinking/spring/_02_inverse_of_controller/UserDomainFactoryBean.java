package prosayj.thinking.spring._02_inverse_of_controller;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * ConnectionFactoryBean
 *
 * @author yangjian
 * @date 2021-01-02 下午 07:43
 * @since 1.0.0
 */
@Data
class UserDomainFactoryBean implements FactoryBean<UserDomain> {
    /**
     * 将依赖的字符串信息变为成员变量, 利用配置文件进行注入
     */
    private String name;
    private int age;


    /**
     * 用于书写创建复杂对象时的代码，并把复杂对象作为返回值对象返回
     *
     * @return Connection
     * @throws Exception Exception
     */
    @Override
    public UserDomain getObject() throws Exception {
        UserDomain userDomain = new UserDomain();
        userDomain.setName(name);
        userDomain.setAge(age);
        return userDomain;
    }

    /**
     * 返回创建的复杂对象的类型(class对象)
     *
     * @return Class<Connection>
     */
    @Override
    public Class<UserDomain> getObjectType() {
        return UserDomain.class;
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
