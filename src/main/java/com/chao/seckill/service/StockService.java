package com.chao.seckill.service;

import com.chao.seckill.dto.Exposer;
import com.chao.seckill.dto.SeckillExecution;
import com.chao.seckill.entity.Stock;
import com.chao.seckill.exception.OrderException;

import java.util.List;

/**
 * 业务接口：站在使用者角度来看
 */
public interface StockService {

    List<Stock> getStocks();

    Stock getById(long id);

    /**
     * 释放秒杀地址
     * @param id
     */
    Exposer exportSeckillUrl(long id);

    /**
     * 执行秒杀操作
     */
    SeckillExecution executeSeckill(long id, long userPhone, String token) throws OrderException;
}
