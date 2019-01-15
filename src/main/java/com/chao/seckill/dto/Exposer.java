package com.chao.seckill.dto;

/**
 * 用来暴露秒杀接口
 */
public class Exposer {

    /**
     * 秒杀是否开启
     */
    private boolean exposed;

    /**
     * 库存 ID
     */
    private long stockId;

    /**
     * 前端加密字串
     */
    private String token;

    /**
     * 系统当前时间
     */
    private long currentTime;

    /**
     * 秒杀开始的时间
     */
    private long startTime;

    /**
     * 秒杀结束时间
     */
    private long endTime;

    public Exposer(boolean exposed, long stockId) {
        this.exposed = exposed;
        this.stockId = stockId;
    }

    public Exposer(boolean exposed, long stockId, String token) {
        this.exposed = exposed;
        this.stockId = stockId;
        this.token = token;
    }

    public Exposer(boolean exposed, long stockId, String token, long currentTime, long startTime, long endTime) {
        this.exposed = exposed;
        this.stockId = stockId;
        this.token = token;
        this.currentTime = currentTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", stockId=" + stockId +
                ", token='" + token + '\'' +
                ", currentTime=" + currentTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
