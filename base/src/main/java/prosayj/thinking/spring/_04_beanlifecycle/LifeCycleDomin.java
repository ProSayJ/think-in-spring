package prosayj.thinking.spring._04_beanlifecycle;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * LifeCycleDomin
 *
 * @author yangjian
 * @date 2021-01-02 下午 09:28
 * @since 1.0.0
 */
@ToString
class LifeCycleDomin implements InitializingBean, DisposableBean {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String name;

    //--------------------------- InitializingBean 接口----

    /**
     * 根据需求实现的方法, 完成初始化操作
     *
     * @throws Exception exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("================>LifeCycleDomin afterPropertiesSet 方法执行");
    }


    //--------------------------- DisposableBean 接口----

    /**
     * 定义销毁方法, 完成销毁操作
     *
     * @throws Exception Exception
     */
    @Override
    public void destroy() throws Exception {
        logger.info("================>LifeCycleDomin destroy 方法执行");
    }


    /**
     * 自定义 myAfterPropertiesSet 方法
     */
    public void myAfterPropertiesSet() {
        logger.info("================>LifeCycleDomin 自定义 myAfterPropertiesSet 方法执行");
    }

    /**
     * 自定义 myDestoryMethod 方法
     */
    public void myDestroy() {
        logger.info("================>LifeCycleDomin 自定义 myDestoryMethod 方法执行");
    }


    /**
     * 无参构造方法
     */
    public LifeCycleDomin() {
        logger.info("LifeCycleDomin 无参构造方法 方法执行~~~~");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        logger.info("LifeCycleDomin set[name] 方法执行~~~");
    }

}
