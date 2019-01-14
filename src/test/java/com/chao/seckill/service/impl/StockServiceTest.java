package com.chao.seckill.service.impl;

import com.chao.seckill.dto.Exposer;
import com.chao.seckill.dto.SeckillExecution;
import com.chao.seckill.entity.Stock;
import com.chao.seckill.exception.OrderException;
import com.chao.seckill.service.StockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-service.xml"})
public class StockServiceTest {

    @Autowired
    StockService stockService;
    @Test
    public void getStocks() {
        List<Stock> stocks = stockService.getStocks();
        stocks.stream().forEach(System.out::println);
    }

    @Test
    public void getById() {
        long id = 1000;
        Stock stock = stockService.getById(id);
        System.out.println(stock);
    }

    @Test
    public void exportSeckillUrl() {
        long id = 1000;
        Exposer exposer = stockService.exportSeckillUrl(id);
        try {
            if(exposer.isExposed()){
                executeSeckill(exposer);
            }
        }catch (OrderException e){
            System.out.println(e);
        }

        System.out.println(exposer);
    }

    public void executeSeckill(Exposer exposer) {
        long id = 1002;
        long userPhone = 13512345678L;
        SeckillExecution seckillExecution = stockService.executeSeckill(id, userPhone, exposer.getToken());
        System.out.println(seckillExecution);
    }
}