package prosayj.thinking.spring._00_design_pattern.delegation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 代理模式
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class DelegateTest {
    public final Logger logger = LoggerFactory.getLogger(getClass());

    @DisplayName("设计模式-代理模式")
    @Test
    public void m1() {
        new Printer().print();
    }

    /**
     * 代理打印机
     *
     * @author yangjian
     */
    class Printer {
        RealPrinter p = new RealPrinter();
        void print() {
            logger.info("代理  doSomeThing~~~~");
            p.print();
            logger.info("代理  doSomeThing~~~~");
        }
    }

    /**
     * the "delegate"：真实的打印机
     *
     * @author yangjian
     */
    class RealPrinter {
        void print() {
            logger.info("打印机  doSomeThing~~~~");
        }
    }
}


