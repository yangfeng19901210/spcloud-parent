package com.yf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import com.yf.mapper.BusOrderMapper;
import com.yf.entity.BusOrder;
import com.yf.service.BusOrderService;
import org.springframework.stereotype.Service;

/**
 * 订单信息表(BusOrder)表服务实现类
 *
 * @author yangfeng
 * @since 2022-11-14 10:38:33
 */
@Slf4j
@Service("busOrderService")
public class BusOrderServiceImpl extends ServiceImpl<BusOrderMapper, BusOrder> implements BusOrderService {

}

