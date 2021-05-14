package designpattern.factory.noodles;

/**
 * 热干面
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class ReganNoodles implements Noodles {
    @Override
    public void desc() {
        System.out.println("红油热干面，武汉特色小吃");
    }
}
