package com.yf.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yf.entity.SysUser;
import com.yf.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName RedisController
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/12 12:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {

    private static final String USERS_KEY = "users";

    private final RedisTemplate redisTemplate;

    private final SysUserService sysUserService;

    @GetMapping("/save")
    public String save(String key, String value){
        redisTemplate.opsForValue().set(key, value);
        return "ok";
    }
    @GetMapping("/getUsers")
    public String setUsersToRedis(){
        String startDate = "1992-03-29";
        String endDate = "1997-03-29";
        LambdaQueryWrapper<SysUser> query = new LambdaQueryWrapper<SysUser>();
        query.ge(SysUser::getDateOfBirth,startDate).le(SysUser::getDateOfBirth,endDate);
        List<SysUser> sysUsers = sysUserService.list(query);
        redisTemplate.opsForValue().set(USERS_KEY, JSON.toJSONString(sysUsers));
        String jsonStr = (String) redisTemplate.opsForValue().get(USERS_KEY);
        return jsonStr;

    }


}
