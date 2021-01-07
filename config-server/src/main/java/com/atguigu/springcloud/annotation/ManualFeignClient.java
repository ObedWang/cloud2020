package com.atguigu.springcloud.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author : wangebie
 * @date : 2021/1/6 17:15
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ManualFeignClient {
    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";

}
