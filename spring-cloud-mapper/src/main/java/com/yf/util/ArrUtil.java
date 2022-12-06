package com.yf.util;

import java.util.List;

/**
 * @ClassName ArrUtil
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/16 17:38
 * @Version 1.0
 */
public class ArrUtil {

    public static boolean arrIsBlank(List<?> list){
        boolean result = false;
        if(null==list || list.size()==0){
            result = true;
        }
        return result;
    }
}
