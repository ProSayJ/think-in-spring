package prosayj.thinking.spring.proxy.dynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Before
 *
 * @author yangjian201127@credithc.com
 * @date 2021-01-31 下午 10:50
 * @since 1.0.0
 */
public class Before implements MethodBeforeAdvice {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 在原始方法执行之前运行的额外功能
     * <p>
     * Method: 额外功能所增加给的那个原始方法
     * <p>
     * Object[]:  额外功能所增加给的那个原始方法的参数
     * <p>
     * Object: 额外功能所增加给的那个原始对象
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        logger.info("---method before advice log---");
    }
}