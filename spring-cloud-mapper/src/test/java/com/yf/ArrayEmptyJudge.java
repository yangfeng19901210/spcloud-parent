package com.yf;

import com.yf.dto.UserDTO;
import com.yf.entity.SysUser;
import com.yf.util.ArrUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName ArrayEmptyJudge
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/16 17:32
 * @Version 1.0
 */
public class ArrayEmptyJudge {

    @ParameterizedTest
    @MethodSource("params")
    public void testArrEmpty(UserDTO userDTO){
        assertTrue(ArrUtil.arrIsBlank(userDTO.getProcess()));
    }

    static Stream<UserDTO> params() {
        UserDTO userDTO = new UserDTO();
        List<String> process = new ArrayList<String>();
        //process.add("123123");
        userDTO.setProcess(process);
        return Stream.of(userDTO);
    }


}
