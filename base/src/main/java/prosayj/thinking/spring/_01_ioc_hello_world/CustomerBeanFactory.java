package prosayj.thinking.spring._01_ioc_hello_world;

import prosayj.thinking.spring.common.dao.UserDao;
import prosayj.thinking.spring.common.service.UserService;

import java.io.IOException;
import java.util.Properties;

/**
 * BeanFactory
 *
 * @author yangjian
 * @date 2020-12-26 上午 09:29
 * @since 1.0.0
 */
class CustomerBeanFactory {
    private static final Properties ENV = new Properties();

    static {
        try {
            ENV.load(CustomerBeanFactory.class.getResourceAsStream("/applicationContext.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用工厂的使用方式：
     * <br>1 定义类型（类）
     * <br>2 通过配置文件告知工厂(applicationContext.properties) key value
     * <br>3 通过工厂获得类对象
     *
     * @param key key
     * @return Object
     */
    public static Object getBean(String key) {
        try {
            return Class
                    .forName(ENV.getProperty(key))
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对象的创建方式
     * <br>1.直接 new 高度耦合
     * <br>2.通过反射获取对象来解耦
     *
     * @return UserService
     */
    public static UserService getUserService() {
        //return new UserServiceImpl();
        try {
            return (UserService) Class
                    .forName("prosayj.thinking.spring.common.service.UserServiceImpl")
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static UserDao getUserDao() {
        //return new UserDaoImpl();
        try {
            return (UserDao) Class
                    .forName("prosayj.thinking.spring.common.dao.UserDaoImpl")
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

