package prosayj.handwritten.mvcframework.annotations;

import java.lang.annotation.*;

/**
 * MyRequestMapping
 *
 * @author yangjian
 * @date 2021-05-19
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRequestMapping {
    String value() default "";
}
