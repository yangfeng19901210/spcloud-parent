package com.yf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yf.entity.SysUser;
import com.yf.mapper.SysUserMapper;
import com.yf.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 用户信息表(SysUser)表服务实现类
 *
 * @author yangfeng
 * @since 2022-11-10 16:13:14
 */
@Slf4j
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            5,
            10,
            1,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    private Map<String, Object> map = new HashMap<String, Object>();
//    @PostConstruct
//    private void getUsers(){
//        //map.put("users",this.list());
////        Thread hisOrderTask = new Thread();
////        hisOrderTask.start();
//        executor.execute(new HisOrderTask());
//
//    }


    @Override
    public List<SysUser> getUserByIm() {
        return (List<SysUser>) map.get("ordersData");
    }

    @Override
    public void setOrderDataToMap(String startDate,String endDate,List<SysUser> list) {
        this.map.clear();
        this.map.put("startTime",startDate);
        this.map.put("endTime",endDate);
        this.map.put("ordersData",list);
    }

    @Override
    public Page<SysUser> queryPage(Integer current, Integer size, SysUser query) {
        if(null==current){
            current = 1;
        }
        if(null==size){
            size = 10;
        }
        LambdaQueryWrapper<SysUser> lamQuery = new LambdaQueryWrapper<>();
        lamQuery.like(StringUtils.isNotBlank(query.getName()),SysUser::getName,query.getName()).ge(null!=query.getAge(),SysUser::getAge,query.getAge());
        return this.page(new Page<>(current,size),lamQuery);
    }
}

