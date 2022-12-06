package com.yf.controller;

import com.yf.task.ExcepHandle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/17 14:10
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            5,
            10,
            1,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100),
            new ThreadPoolExecutor.DiscardOldestPolicy());
    @RequestMapping("/testMethodExecute")
    public String testMethodExecute(){
        threadPool.execute(new ExcepHandle());
        return "ok";
    }
}
