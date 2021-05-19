package prosayj.handwritten.mvcframework.annotations;

import java.lang.annotation.*;

/**
 * MyService
 *
 * @author yangjian
 * @date 2021-05-19
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyService {
    String value() default "";
}
