package com.yf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MapperApp
 * @Description TODO mapper 启动类
 * @Author @yangfeng
 * @Date 2022/11/10 13:55
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.yf.mapper")
public class MapperApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(MapperApp.class, args);
        System.out.println(configurableApplicationContext.getBean("springContextUtil"));

    }
}
