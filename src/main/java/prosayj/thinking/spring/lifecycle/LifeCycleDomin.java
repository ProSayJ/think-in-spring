package prosayj.thinking.spring.lifecycle;

import lombok.Data;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Product
 *
 * @author yangjian201127@credithc.com
 * @date 2021-01-02 下午 09:28
 * @since 1.0.0
 */
@ToString
public class LifeCycleDomin implements InitializingBean, DisposableBean {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.info("LifeCycleDomin set name~");
        this.name = name;
    }

    public LifeCycleDomin() {
        logger.info("LifeCycleDomin init~");
    }

    /**
     * 根据需求实现的方法, 完成初始化操作
     *
     * @throws Exception exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("================>LifeCycleDomin.afterPropertiesSet");
    }

    public void myInit() {
        logger.info("================>LifeCycleDomin.myInit");
    }


    /**
     * 定义销毁方法, 完成销毁操作
     *
     * @throws Exception Exception
     */
    @Override
    public void destroy() throws Exception {
        logger.info("================>LifeCycleDomin.destroy");
        System.out.println("================>LifeCycleDomin.destroy");
    }

    public void myDestory() {
        logger.info("================>LifeCycleDomin.myDestory");
        System.out.println("================>LifeCycleDomin.myDestory");
    }

}
