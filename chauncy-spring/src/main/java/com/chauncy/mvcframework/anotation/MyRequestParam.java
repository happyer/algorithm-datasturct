package com.chauncy.mvcframework.anotation;

import java.lang.annotation.*;

/**
 * Created by chauncy on 2019/3/26.
 */

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestParam {

    String value() default "";
}
