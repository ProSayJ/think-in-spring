package prosayj.handwritten.mvcframework.annotations;

import java.lang.annotation.*;

/**
 * MyAutowired
 *
 * @author yangjian
 * @date 2021-05-19
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAutowired {
    String value() default "";
}
