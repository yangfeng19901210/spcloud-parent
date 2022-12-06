package com.yf.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yf.entity.SysUser;
import com.yf.service.SysUserService;
import com.yf.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * @Author yangfeng
 * @Desc 用户信息表(SysUser)表控制层
 * @Date 2022-11-10 16:13:14
 */
@Api(tags = "用户信息表")
@RestController
@RequestMapping("sysUser")
@RequiredArgsConstructor
@Slf4j
public class SysUserController {

    private final SysUserService sysUserService;
    @GetMapping("/getUsersByDb")
    public List<SysUser> getAllUserByDb(){
        long stime = System.currentTimeMillis();
        SysUserService sysUserService = (SysUserService) SpringContextUtil.getBean("sysUserService");
        List<SysUser> list = sysUserService.list();
        long etime = System.currentTimeMillis();
        log.info("执行数据库查询所需时间 {} 毫秒",(etime - stime));
        return list;
    }

    @GetMapping("/getUsersByIm")
    public List<SysUser> getAllUserByIm(){
        long stime = System.currentTimeMillis();
        List<SysUser> list = sysUserService.getUserByIm();
        long etime = System.currentTimeMillis();
        log.info("执行内存查询所需时间 {} 毫秒",(etime - stime));
        return list;
    }

    @PostMapping("/selectByPage")
    public Page<SysUser> getAllUserByIm(Integer current,Integer size,@RequestBody SysUser sysUser){
        return sysUserService.queryPage(current,size,sysUser);
    }

}
