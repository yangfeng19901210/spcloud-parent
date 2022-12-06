package com.yf.controller;

import com.yf.entity.BusOrder;
import com.yf.service.BusOrderService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * @Author yangfeng
 * @Desc 订单信息表(BusOrder)表控制层
 * @Date 2022-11-14 10:38:33
 */
@Api(tags = "订单信息表")
@RestController
@RequestMapping("busOrder")
@RequiredArgsConstructor
public class BusOrderController {

    private final BusOrderService busOrderService;

}
