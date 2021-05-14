package designpattern.singleton;

/**
 * 饿汉式（立即加载）
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class HungrySingleton {

    /**
     * 构造方法私有化
     */
    private HungrySingleton() {
    }

    /**
     * 将自身实例化对象设置为一个属性，并用static、final修饰
     */
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    /**
     * 静态方法返回该实例
     *
     * @return HungrySingleton
     */
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
