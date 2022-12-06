package com.yf.processor;

import com.yf.anno.RedisListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @projectName: spcloud-parent
 * @package: com.yf.processor
 * @className: RedisCustomerBeanPostProcessor
 * @author: yangfeng
 * @description: 监听redis 队列的后置处理器
 * @date: 2022/11/22 10:42
 * @version: 1.0
 */
@Component  //交给spring容器管理
public class RedisCustomerBeanPostProcessor implements BeanPostProcessor, SmartInitializingSingleton {
    /**
     * @Author yangfeng
     * @Description //spring 容器的前置处理器
     * @Date 10:47 2022/11/22 
     * @param bean: 
     * @param beanName: 
     * @return java.lang.Object
     **/
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("执行前置操作。。。。");
        return bean;
    }
    /**
     * @Author yangfeng
     * @Description spring 容器的后置处理器
     * @Date 10:46 2022/11/22
     * @param bean: 经过spring加工后的Bean对象
     * @param beanName: 经过spring处理后的bean的名称
     * @return java.lang.Object 返回bean对象
     **/
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //添加自己的处理逻辑
        //System.out.println("执行后置操作");
        //获取所有添加@RedisListener方法所属的类并添加到指定的容器中
        return bean;
    }

    @Override
    public void afterSingletonsInstantiated() {
        //System.out.println("所有的bean初始化完成，开始执行一些后置操作");
    }
    //执行类对应的方法
    public void executeMethod(Object bean){
        Method[] methods = bean.getClass().getDeclaredMethods();
        if(methods.length>0){
            for (Method method : methods) {
                RedisListener redisListener = AnnotationUtils.findAnnotation(method, RedisListener.class);
                if(null!=redisListener){
                    try {
                        Class<?>[] types = method.getParameterTypes();
                        Object [] args = new Object[types.length];
                        for (int i=0;i<types.length;i++){
                            args[i] = null;
                        }
                        if(types.length>0){
                            method.invoke(bean,args);
                        }else{
                            method.invoke(bean);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }

}
