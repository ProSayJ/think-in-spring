package prosayj.spring.iocaop.annotation.transfer.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 日志工具类
 *
 * @author yangjian
 * @date 2021-05-13
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class LogUtils {
    private static final String TRANSFORE_ASPECT =
            "execution(* prosayj.spring.iocaop.annotation.transfer.service.impl.TransferServiceImpl.*(..))";

    @Pointcut(TRANSFORE_ASPECT)
    public void pt1() {
    }


    /**
     * 业务逻辑开始之前执行
     */
    @Before("pt1()")
    public void beforeMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("业务逻辑开始执行之前执行.......beforeMethod");
    }


    /**
     * 业务逻辑结束时执行（无论异常与否）
     */
    @After("pt1()")
    public void afterMethod() {
        System.out.println("业务逻辑结束时执行，无论异常与否都执行.......afterMethod");
    }

    /**
     * 业务逻辑正常时执行
     */
    @AfterReturning(value = "pt1()", returning = "retVal")
    public void successMethod(Object retVal) {
        System.out.println("业务逻辑正常时执行.......successMethod");
    }


    /**
     * 异常时时执行
     */
    @AfterThrowing("pt1()")
    public void exceptionMethod() {
        System.out.println("异常时执行.......exceptionMethod");
    }


    /**
     * 环绕通知
     */
    @Around("pt1()")
    public Object arroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知中的....beforemethod");
        Object result;
        try {
            // 控制原有业务逻辑是否执行
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("环绕通知中的....exceptionmethod");
            throw e;
        } finally {
            System.out.println("环绕通知中的....after method");
        }

        return result;
    }

}
