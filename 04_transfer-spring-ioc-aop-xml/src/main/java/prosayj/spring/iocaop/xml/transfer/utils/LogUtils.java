package prosayj.spring.iocaop.xml.transfer.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志工具类
 *
 * @author yangjian
 * @date 2021-05-13
 */
public class LogUtils {


    public void pt1() {

    }


    /**
     * 业务逻辑开始之前执行
     */
    public void beforeMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("业务逻辑开始执行之前执行.......");
    }


    /**
     * 业务逻辑结束时执行（无论异常与否）
     */
    public void afterMethod() {
        System.out.println("业务逻辑结束时执行，无论异常与否都执行.......");
    }


    /**
     * 异常时时执行
     */
    public void exceptionMethod() {
        System.out.println("异常时执行.......");
    }


    /**
     * 业务逻辑正常时执行
     */
    public void successMethod(Object retVal) {
        System.out.println("业务逻辑正常时执行.......");
    }


    /**
     * 环绕通知
     */
    public Object arroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知中的beforemethod....");

        Object result = null;
        try {
            // 控制原有业务逻辑是否执行
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (Exception e) {
            System.out.println("环绕通知中的exceptionmethod....");
        } finally {
            System.out.println("环绕通知中的after method....");
        }

        return result;
    }

}
