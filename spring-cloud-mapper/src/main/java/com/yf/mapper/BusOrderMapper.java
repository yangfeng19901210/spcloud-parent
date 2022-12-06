package com.yf.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.yf.entity.BusOrder;

/**
 * 订单信息表(BusOrder)表数据库访问层
 *
 * @author yangfeng
 * @since 2022-11-14 10:38:33
 */
@Mapper
public interface BusOrderMapper extends BaseMapper<BusOrder> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BusOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BusOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BusOrder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BusOrder> entities);

}

