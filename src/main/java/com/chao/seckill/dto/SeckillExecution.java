package com.chao.seckill.dto;

import com.chao.seckill.common.StateEnum;
import com.chao.seckill.entity.Order;

/**
 * 秒杀执行后
 */
public class SeckillExecution {

    private long stockId;

    /**
     * 秒杀执行结果： -1 无效 0 成功
     */
    private int state;

    /**
     * 解释状态：字符串类型，只为展示用
     */
    private String stateInfo;

    /**
     * 秒杀订单
     */
    private Order order;

    public SeckillExecution(long stockId, StateEnum state, Order order) {
        this.stockId = stockId;
        this.state = state.getState();
        this.stateInfo = state.getStateInfo();
        this.order = order;
    }

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "stockId=" + stockId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", order=" + order +
                '}';
    }
}
