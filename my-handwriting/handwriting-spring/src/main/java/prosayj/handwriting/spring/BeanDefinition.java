package prosayj.handwriting.spring;

/**
 * BeanDefinition
 *
 * @author yangjian
 * @since 1.0.0 <br>2021-07-16 上午 09:33
 */
public class BeanDefinition {
    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    private Class<?> clazz;
    private String scope;


    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
