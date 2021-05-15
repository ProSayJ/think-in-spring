package prosayj.spring.iocaop.xml.transfer.utils;


/**
 * @author 应癫
 */
public class CreateBeanFactory {


    /**
     * 静态方法实例化Bean
     * @return ConnectionUtils
     */
    public static ConnectionUtils getInstanceStatic() {
        return new ConnectionUtils();
    }

    /**
     * 静态方法实例化Bean
     * @return ConnectionUtils
     */
    public ConnectionUtils getInstance() {
        return new ConnectionUtils();
    }
}
