package com.yf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @projectName: spcloud-parent
 * @package: com.yf
 * @className: App
 * @author: yangfeng
 * @description: 启动类
 * @date: 2022/11/6 21:03
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
