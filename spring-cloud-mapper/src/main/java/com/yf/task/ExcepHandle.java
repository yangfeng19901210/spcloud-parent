package com.yf.task;

import cn.hutool.core.date.DateUtil;

/**
 * @ClassName ExcepHandle
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/17 14:07
 * @Version 1.0
 */
public class ExcepHandle implements Runnable{
    private static Integer count = 1;
    @Override
    public void run() {
        try {
            while(count<=2){
                count++;
                System.out.println(DateUtil.now());
                Thread.sleep(5*1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
