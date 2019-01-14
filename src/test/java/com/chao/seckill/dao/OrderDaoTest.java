package com.chao.seckill.dao;

import com.chao.seckill.entity.Order;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
  //  @Ignore
    public void insert(){
        long id = 1000;
        long phone = 13512345678L;
        int rows = orderDao.insert(id, phone);
        System.out.println(rows);
    }

    @Test
    public void queryStockById(){
        long id = 1000;
        long phone = 13512345678L;
        Order order = orderDao.queryStockById(id, phone);
        System.out.println(order);
    }

}