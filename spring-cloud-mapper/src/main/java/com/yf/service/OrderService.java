package com.yf.service;

import com.yf.task.HisOrderTask;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/11 10:22
 * @Version 1.0
 */
//@Component
public class OrderService {

    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            5,
            10,
            1,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100),
            new ThreadPoolExecutor.DiscardOldestPolicy());
    @PostConstruct
    private void getUsers(){
//        new Thread(new HisOrderTask()).start();
        executor.execute(new HisOrderTask());

    }
}
