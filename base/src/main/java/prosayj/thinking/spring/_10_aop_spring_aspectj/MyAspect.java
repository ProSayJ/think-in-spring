package prosayj.thinking.spring._10_aop_spring_aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-07-04 下午 11:46
 * @since 1.0.0
 */
@Aspect
public class MyAspect {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* *..UserServiceImpl.*(..))")
    public void myPointcut(){}

    @Around(value="myPointcut()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("------aspect  log  before --------");
        Object ret = joinPoint.proceed();
        logger.info("------aspect  log after --------");
        return ret;
    }


    @Around(value="myPointcut()")
    public Object arround1(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("------aspect  tx  before --------");
        Object ret = joinPoint.proceed();
        logger.info("------aspect  tx  after --------");
        return ret;
    }
}
