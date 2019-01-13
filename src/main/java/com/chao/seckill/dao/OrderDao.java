package com.chao.seckill.dao;

import com.chao.seckill.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderDao {

    /**
     * 保存订单信息
     * @param stockId
     * @param userPhone
     * @return 插入数据的行数
     */
    int insert(@Param("stockId") long stockId,@Param("userPhone") long userPhone);

    /**
     * 查询订单信息
     * @param stockId
     * @return
     */
    Order queryStockById(@Param("stockId") long stockId,@Param("userPhone") long userPhone);
}
