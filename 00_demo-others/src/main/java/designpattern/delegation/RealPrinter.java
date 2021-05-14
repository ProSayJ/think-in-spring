package designpattern.delegation;

/**
 * 真实的打印机
 *
 * @author yangjian
 * @date 2021-05-14
 */
class RealPrinter { // the "delegate"
    void print() {
        System.out.print("something");
    }
}
