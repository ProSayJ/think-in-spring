package prosayj.springtest.spring;

/**
 * TODO
 *
 * @author yangjian
 * @since 1.0.0 <br>2021-07-16 下午 12:56
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}