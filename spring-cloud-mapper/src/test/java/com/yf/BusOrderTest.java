package com.yf;

import com.yf.entity.BusOrder;
import com.yf.service.BusOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName BusOrderTest
 * @Description TODO
 * @Author @yangfeng
 * @Date 2022/11/10 14:40
 * @Version 1.0
 */
@SpringBootTest
public class BusOrderTest {
    @Resource
    private BusOrderService busOrderService;

    //测试订单新增
    @Test
    public void testAddOrder(){
        BusOrder busOrder = new BusOrder();
        busOrder.setOrdNo("010033");
        busOrder.setGoodsName("黑芝麻");
        busOrder.setSpec("1000kg*24包");
        busOrder.setUserId(39);
        busOrder.insert();

    }
    //更新订单信息
    @Test
    public void testUpdateOrder(){
        BusOrder busOrder = busOrderService.getById(8);
        busOrder.setCreateBy("lisi");
        busOrderService.saveOrUpdate(busOrder);

    }

    //测试订单删除
    @Test
    public void testDeleteOrder(){
        busOrderService.removeById(4);
    }


}
