package designpattern.factory.noodles;

/**
 * 泡面
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class PaoNoodles implements Noodles {
    @Override
    public void desc() {
        System.out.println("泡面，程序员必备");
    }
}
