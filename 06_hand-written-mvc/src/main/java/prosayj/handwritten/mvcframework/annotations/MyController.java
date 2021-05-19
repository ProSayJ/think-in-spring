package prosayj.handwritten.mvcframework.annotations;

import java.lang.annotation.*;

/**
 * MyController
 *
 * @author yangjian
 * @date 2021-05-19
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyController {
    String value() default "";
}
