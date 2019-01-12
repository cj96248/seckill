package com.chao.seckill.dao;

import com.chao.seckill.entity.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StockDaoTest {

    @Autowired
    private StockDao stockDao;

    @Test
    public void reduceAmount(){
        long id = 1001;
        Date date = new Date();
        int number = stockDao.reduceAmount(id, date);
        System.out.println(number);

    }

 //   @Test
    public void queryById(){
        long id = 1000;
        Stock stock = stockDao.queryById(id);
        System.out.println(stock);
    }

 //   @Test
    public void queryAll(){
        int limit = 10;
        int offset = 0;
        stockDao.queryAll(offset, limit);
    }
}