package com.yf.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yf.entity.SysUser;

import java.util.List;

/**
 * 用户信息表(SysUser)表服务接口
 *
 * @author yangfeng
 * @since 2022-11-10 16:13:14
 */
public interface SysUserService extends IService<SysUser> {

    List<SysUser> getUserByIm();

    void setOrderDataToMap(String startDate,String endDate,List<SysUser> list);


    public Page<SysUser> queryPage(Integer current,Integer size,SysUser query);

}

