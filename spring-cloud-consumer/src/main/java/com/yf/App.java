package com.yf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName App
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/7 10:56
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class App {
//    @Value("${user.name}")
//    private String name;

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
        //获取并输出nacos配置文件属性值
        String userName = applicationContext.getEnvironment().getProperty("k1");
        String userAge = applicationContext.getEnvironment().getProperty("app.t2");
        String name = applicationContext.getEnvironment().getProperty("app.t3");
        String y1 = applicationContext.getEnvironment().getProperty("app.y1");
        System.err.println("user name :" +userName+"; age: "+userAge);
        System.err.println("y1 :" +y1+"; age: "+userAge);
    }

    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }

}
