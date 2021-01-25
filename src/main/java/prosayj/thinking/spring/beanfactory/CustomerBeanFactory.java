package prosayj.thinking.spring.beanfactory;

import prosayj.thinking.spring.basic.dao.UserDao;
import prosayj.thinking.spring.basic.service.UserService;

import java.io.IOException;
import java.util.Properties;

/**
 * BeanFactory
 *
 * @author yangjian201127@credithc.com
 * @date 2020-12-26 上午 09:29
 * @since 1.0.0
 */
public class CustomerBeanFactory {
    private static final Properties env = new Properties();

    static {
        try {
            env.load(CustomerBeanFactory.class.getResourceAsStream("/applicationContext.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用工厂的使用方式
     * 1 定义类型（类）
     * 2 通过配置文件告知工厂(applicationContext.properties)
     *      key value
     * 3 通过工厂获得类对象
     *
     * @param key key
     * @return Object
     */
    public static Object getBean(String key) {
        try {
            return Class
                    .forName(env.getProperty(key))
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对象的创建方式
     * 1.直接 new 高度耦合
     * 2.通过反射获取对象来解耦
     *
     * @return UserService
     */
    public static UserService getUserService() {
        //return new UserServiceImpl();
        try {
            return (UserService) Class
                    .forName("prosayj.thinking.spring.basic.service.impl.UserServiceImpl")
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static UserDao getUserDao() {
//        return new UserDaoImpl();
        try {
            return (UserDao) Class
                    .forName("prosayj.thinking.spring.basic.dao.impl.UserDaoImpl")
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

