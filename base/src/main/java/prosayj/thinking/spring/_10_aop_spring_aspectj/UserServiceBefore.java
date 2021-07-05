//package prosayj.thinking.spring._10_aop_spring_aspectj;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.MethodBeforeAdvice;
//
//import java.lang.reflect.Method;
//
///**
// * 动态代理
// *
// * @author yangjian
// * @date 2021-01-31 下午 10:50
// * @since 1.0.0
// */
//class UserServiceBefore implements MethodBeforeAdvice {
//    public final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    /**
//     * 作用：需要把运行在原始方法执行之前运行的额外功能，写在before方法中
//     * <p>
//     * Method: 额外功能所增加给的那个原始方法
//     * <p>
//     * Object[]:  额外功能所增加给的那个原始方法的参数
//     * <p>
//     * Object: 额外功能所增加给的那个原始对象
//     */
//    @Override
//    public void before(Method method, Object[] objects, Object o) throws Throwable {
//        logger.info("---method before advice log---");
//    }
//}