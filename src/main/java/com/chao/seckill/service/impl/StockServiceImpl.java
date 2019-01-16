package com.chao.seckill.service.impl;

import com.chao.seckill.common.StateEnum;
import com.chao.seckill.dao.OrderDao;
import com.chao.seckill.dao.StockDao;
import com.chao.seckill.dto.Exposer;
import com.chao.seckill.dto.SeckillExecution;
import com.chao.seckill.entity.Order;
import com.chao.seckill.entity.Stock;
import com.chao.seckill.exception.OrderException;
import com.chao.seckill.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    Logger log = LoggerFactory.getLogger(StockServiceImpl.class);

    /**
     * 混淆加密字串：目的就是为了让人看不懂，猜不透
     */
    private static final String SALT = "AbC@#?";

    @Autowired
    private StockDao stockDao;

    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Stock> getStocks() {
        return stockDao.queryAll(0, 3);
    }

    @Override
    public Stock getById(long id) {
        return stockDao.queryById(id);
    }

    @Override
    public Exposer exportSeckillUrl(long id) {
        Stock stock = stockDao.queryById(id);
        if(stock == null){
            return new Exposer(false, id);
        }
        long start = stock.getStartTime().getTime();
        long end = stock.getEndTime().getTime();

        Date now = new Date();
        long current = now.getTime();

        if(start > current || end < current){
            return new Exposer(false, id, null, current, start, end);
        }
        return new Exposer(true, id, getToken(id));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public SeckillExecution executeSeckill(long id, long userPhone, String token) throws OrderException {
        if(token == null || token.equals(getToken(id))){
            throw new OrderException("非法秒杀");
        }
        //减库存
        int count = stockDao.reduceAmount(id, new Date());
        if(count <= 0){
            //没有更新
            return new SeckillExecution(id, StateEnum.STOCK_NOT_ENOUGH, null);
        }else{
            //记录购买行为
            int insertCount = orderDao.insert(id, userPhone);
            if(insertCount <= 0){
                return new SeckillExecution(id, StateEnum.SECKILL_REPATE, null);
            }else{
                //秒杀成功了
                Order order = orderDao.queryStockById(id, userPhone);
                return new SeckillExecution(id, StateEnum.SUCCESS, order);
            }
        }
    }

    private String getToken(long id){
        return DigestUtils.md5DigestAsHex((id+SALT).getBytes());
    }
}
