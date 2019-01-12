package com.chao.seckill.dao;

import com.chao.seckill.entity.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StockDao {

    /**
     * 减库存
     * @param id
     * @param killTime 执行减库存的时间
     * @return 更新语句执行的行数
     */
    int reduceAmount(@Param("id") long id,@Param("killTime") Date killTime);

    /**
     * 根据ID 查询
     * @param id
     * @return
     */
    Stock queryById(long id);

    /**
     * 分页查询
     * @param offset
     * @param limit
     * @return
     */
    List<Stock> queryAll(@Param("offset") int offset,@Param("limit") int limit);

}
