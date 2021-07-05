package prosayj.thinking.spring._11_spring_tx;

import prosayj.thinking.spring.common.env.ClasspathContextSetEnv;

/**
 * Spring事务测试用例：
 * <p>如何控制事务:<br>
 * <p>1:JDBC:<br>
 * Connection.setAutoCommit(false); <br>
 * Connection.commit();<br>
 * Connection.rollback();<br>
 * <p>2:Mybatis：<br>
 * Mybatis自动开启事务 <br>
 * sqlSession(Connection).commit(); <br>
 * sqlSession(Connection).rollback(); <br>
 * <p>
 * 结论：控制事务的底层 都是Connection对象完成的。<br>
 *
 * @author yangjia
 * @since 1.0.0
 */
public class SpringTxTest extends ClasspathContextSetEnv {
    public SpringTxTest() {
        super("test/11_SpringTxTest.xml");
    }
}
