package com.yf.service;

import cn.hutool.json.JSONObject;
import com.yf.anno.RedisListener;
import org.springframework.stereotype.Service;

/**
 * @projectName: spcloud-parent
 * @package: com.yf.service
 * @className: TestService
 * @author: yangfeng
 * @description: TODO
 * @date: 2022/11/22 10:55
 * @version: 1.0
 */
@Service
public class TestService {
    @RedisListener(queues = {"user.id"})
    public void hello(JSONObject json){
        System.out.println(json);
    }

    @RedisListener(queues = {"order.msg"})
    public void syaHello(JSONObject json){
        System.out.println(json);
    }

}
