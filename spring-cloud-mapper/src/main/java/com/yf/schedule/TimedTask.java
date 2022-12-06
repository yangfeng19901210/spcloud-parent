package com.yf.schedule;

import com.yf.task.HisOrderTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TimedTask
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/10 17:54
 * @Version 1.0
 */
@Configuration
@EnableScheduling
@Slf4j
@DependsOn("springContextUtil")
public class TimedTask {

    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            5,
            10,
            1,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    /**
     * @Author @yangfeng
     * @Description // 每天凌晨开启线程获取订单缓存数据
     * @Date 18:17 2022/11/10
     * @return void
     **/
    @Scheduled(cron = "0 */5 * * * ?")
    private void timeGetOrderData(){
        executor.execute(new HisOrderTask());
    }
}
