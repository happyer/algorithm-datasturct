package com.chauncy.mvcframework.anotation;

import java.lang.annotation.*;

/**
 * Created by chauncy on 2019/3/26.
 */


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMapping {
    String value() default "";
}
