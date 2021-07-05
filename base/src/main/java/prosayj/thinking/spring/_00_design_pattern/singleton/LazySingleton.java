package prosayj.thinking.spring._00_design_pattern.singleton;

/**
 * 懒汉式（延时加载）
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class LazySingleton {

    /**
     * 将自身实例化对象设置为一个属性，并用static修饰
     */
    private static LazySingleton instance;

    /**
     * 构造方法私有化
     */
    private LazySingleton() {
    }

    /**
     * 静态方法返回该实例，加synchronized关键字实现同步
     *
     * @return LazySingleton
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
