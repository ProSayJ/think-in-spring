package oop.support;

/**
 * 动物类
 *
 * @author yangjian
 * @date 2021-05-13
 */
public class Animal {
    /**
     * 高度
     */
    private String height;
    /**
     * 体重
     */
    private float weight;

    public void eat() {
        //性能监控代码
        long start = System.currentTimeMillis();


        // 业务逻辑代码
        System.out.println("I can eat...");

        //性能监控代码
        long endTime = System.currentTimeMillis();

        System.out.println("执行时长" + (endTime - start) / 1000f + "s");
    }

    public void run() {
        //性能监控代码
        long start = System.currentTimeMillis();

        // 业务逻辑代码
        System.out.println("I can run...");


        //性能监控代码
        long endTime = System.currentTimeMillis();
        System.out.println("执行时长" + (endTime - start) / 1000f + "s");
    }

}
