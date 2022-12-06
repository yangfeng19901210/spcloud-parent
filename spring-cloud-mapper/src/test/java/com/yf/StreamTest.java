package com.yf;

import com.yf.entity.SysUser;
import com.yf.service.SysUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamTest
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/10 15:17
 * @Version 1.0
 */
@SpringBootTest
public class StreamTest {

    private List<SysUser> list = new ArrayList<SysUser>();
    @Resource
    private SysUserService sysUserService;

    @BeforeEach
    public void initData(){
        list = sysUserService.list();
    }
    // 获取年龄最小的员工
    @Test
    public void getMinAgeUser(){
        list.stream().max(Comparator.comparing(t -> t.getDateOfBirth())).ifPresent(e -> System.out.println(e));

        list.stream().max(Comparator.comparing(SysUser::getDateOfBirth)).ifPresent(e -> System.out.println(e));
    }

    //查询时间端
    @Test
    public void testDateRange(){
        list = list.stream().filter(t->
                t.getDateOfBirth().compareTo("1990-01-23")>=0
                && t.getDateOfBirth().compareTo("1990-03-29")<=0
                && (t.getStatus().equals("2") || t.getStatus().equals("4"))
                && (t.getServiceProcess().equals("15") || t.getServiceProcess().equals("21"))
        ).collect(Collectors.toList());
        System.out.println(list);

        System.out.println("2022-01-02".compareTo("2022-01-02"));
    }

}
