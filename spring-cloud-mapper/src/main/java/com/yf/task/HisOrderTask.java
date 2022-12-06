package com.yf.task;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yf.entity.SysUser;
import com.yf.mapper.SysUserMapper;
import com.yf.service.SysUserService;
import com.yf.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @ClassName HisOrderTask
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/10 17:59
 * @Version 1.0
 */
@Slf4j
public class HisOrderTask implements Runnable{

    @Override
    public void run() {
        SysUserService sysUserService = (SysUserService) SpringContextUtil.getBean("sysUserService");
        String startDate = "1992-03-29";
        String endDate = "1997-03-29";
        LambdaQueryWrapper<SysUser> query = new LambdaQueryWrapper<SysUser>();
        query.ge(SysUser::getDateOfBirth,startDate).le(SysUser::getDateOfBirth,endDate);
        List<SysUser> sysUsers = sysUserService.list(query);
        sysUserService.setOrderDataToMap(startDate,endDate,sysUsers);

    }
}
