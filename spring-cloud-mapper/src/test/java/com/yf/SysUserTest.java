package com.yf;

import com.yf.entity.SysUser;
import com.yf.service.SysUserService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SysUserTest
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/10 14:40
 * @Version 1.0
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserTest {
    @Resource
    private SysUserService sysUserService;
    @Test
    public void initTest(){
        List<SysUser> list = sysUserService.list();
        assertNotNull(list,"用户信息不为空");
        assertEquals(10515,list.size());

    }
    @Test
    public void saveBAtch(){
        //sysUserService.getBaseMapper().delete(null);
        SysUser sysUser1 = new SysUser();
        sysUser1.setName("张三");
        sysUser1.setAge(13);
        sysUser1.setSex("男");
        sysUser1.setSalary(5800.12);
        sysUser1.setDateOfBirth("1990-01-23");
        sysUser1.setAddress("湖心佳苑");
        sysUser1.setStatus("2");
        sysUser1.setServiceProcess("15");


        SysUser sysUser2 = new SysUser();
        sysUser2.setName("李四");
        sysUser2.setAge(14);
        sysUser2.setSex("男");
        sysUser2.setSalary(5100.26);
        sysUser2.setDateOfBirth("1990-02-11");
        sysUser2.setAddress("城南A区");
        sysUser2.setStatus("2");
        sysUser2.setServiceProcess("20");

        SysUser sysUser3 = new SysUser();
        sysUser3.setName("张晓丽");
        sysUser3.setAge(19);
        sysUser3.setSex("女");
        sysUser3.setSalary(4500.12);
        sysUser3.setDateOfBirth("1990-03-29");
        sysUser3.setAddress("杭州西湖");
        sysUser3.setStatus("2");
        sysUser3.setServiceProcess("21");

        SysUser sysUser4 = new SysUser();
        sysUser4.setName("木婉清");
        sysUser4.setAge(23);
        sysUser4.setSex("女");
        sysUser4.setSalary(3200.19);
        sysUser4.setDateOfBirth("1990-04-15");
        sysUser4.setAddress("神华集团");
        sysUser4.setStatus("4");
        sysUser4.setServiceProcess("21");

        SysUser sysUser5 = new SysUser();
        sysUser5.setName("姜玉华");
        sysUser5.setAge(32);
        sysUser5.setSex("男");
        sysUser5.setSalary(6700.13);
        sysUser5.setDateOfBirth("1990-05-23");
        sysUser5.setAddress("衡策股份");
        sysUser5.setStatus("4");
        sysUser5.setServiceProcess("20");

        List<SysUser> sysUsers = Arrays.asList(sysUser1, sysUser2, sysUser3, sysUser4, sysUser5);
        boolean b = sysUserService.saveBatch(sysUsers);
//        for(int i=0;i<1000;i++){
//            boolean b = sysUserService.saveBatch(sysUsers);
//
//        }

    }
}
