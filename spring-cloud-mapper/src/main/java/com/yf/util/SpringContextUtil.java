package com.yf.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

@Configuration
@Order(0)
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    //@Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
        System.out.println(null==applicationContext);
        System.out.println("============");

    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(String name)throws BeansException {
        System.out.println(null==applicationContext);
        return applicationContext.getBean(name);
    }
}
