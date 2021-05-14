package designpattern.factory.noodles;

/**
 * 兰州拉面
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class LzNoodles implements Noodles {
    @Override
    public void desc() {
        System.out.println("兰州拉面，兰州特色小吃");
    }
}
