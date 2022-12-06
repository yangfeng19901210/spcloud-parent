package com.yf.controller;

import cn.hutool.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @projectName: spcloud-parent
 * @package: com.yf.controller
 * @className: TestRedisController
 * @author: yangfeng
 * @description: TODO
 * @date: 2022/11/22 15:53
 * @version: 1.0
 */
@RestController
@RequestMapping("/redisListener")
public class TestRedisController {

    @Resource(name = "MQ")
    private RedisTemplate<String, String> redisMqTemplate;

    //设置用户队列
    @RequestMapping("/setUserQueue")
    public String setUserQueue(Integer id,String name){
        JSONObject object = new JSONObject();
        object.set("id",id);
        object.set("name",name);
        redisMqTemplate.opsForList().leftPush("user.id",object.toString());
        return "ok";
    }

    //设置订单队列
    @RequestMapping("/setOrderQueue")
    public String setOrderQueue(String ordNum,String name){
        JSONObject object = new JSONObject();
        object.set("no",ordNum);
        object.set("productName",name);
        redisMqTemplate.opsForList().leftPush("order.msg",object.toString());
        return "ok";
    }

}
