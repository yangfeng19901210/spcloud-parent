package com.yf.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.common.http.param.MediaType;
import com.yf.entity.SysUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.stream.Stream;

/**
 * @ClassName TestSysUserController
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/11 18:17
 * @Version 1.0
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSysUserController {
    @Autowired
    private WebApplicationContext webAc;

    MockMvc mockMvc;

    @BeforeEach
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAc).build();
    }
    @DisplayName("测试分页查询用户信息")
    @ParameterizedTest
    @MethodSource("queryModel")
    public void testSelectUserPage(SysUser sysUser)throws Exception{
        assertNotNull(sysUser);
        String s = mockMvc.perform(MockMvcRequestBuilders.post(new URI("/sysUser/selectByPage"))
                .param("current", "3")
                .param("size", "100")
                .content(JSON.toJSONString(sysUser))
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse().getContentAsString();
    }

    static Stream<SysUser> queryModel() {
        SysUser sysUser = new SysUser();
        sysUser.setName("玉华");
        sysUser.setAge(18);

        SysUser sysUser1 = new SysUser();
        sysUser1.setName("婉清");
        //sysUser.setAge(18);
        return Stream.of(sysUser,sysUser1);
    }
}
