package com.yf.anno;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;
//用来标识所需要监听的方法的注解类
@Documented
@Target(ElementType.METHOD)
@Order(Ordered.HIGHEST_PRECEDENCE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisListener {
    /**
     * 消费的queue
     */
    String[] queues();

    /**
     * 容器工厂
     */
    String containerFactory() default "";
}
