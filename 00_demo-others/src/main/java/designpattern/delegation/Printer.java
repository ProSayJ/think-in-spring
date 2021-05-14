package designpattern.delegation;

/**
 * 代理打印机
 *
 * @author yangjian
 * @date 2021-05-14
 */
class Printer {
    RealPrinter p = new RealPrinter();

    void print() {
        p.print();
    }
}
