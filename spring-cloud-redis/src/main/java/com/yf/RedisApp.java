package com.yf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName MapperApp
 * @Description TODO mapper 启动类
 * @Author @yangfeng
 * @Date 2022/11/10 13:55
 * @Version 1.0
 */
@SpringBootApplication
public class RedisApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(RedisApp.class, args);

    }
}
