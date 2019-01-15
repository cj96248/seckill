package com.chao.seckill.common;

public enum StateEnum {
    SUCCESS(1,"秒杀成功"),
    SECKILL_END(0,"秒杀结束"),
    STOCK_NOT_ENOUGH(2000, "库存不足"),
    SECKILL_REPATE(2001, "重复秒杀"),
    SYSTEM_ERROR(-2,"系统错误")
    ;

    private int state;

    private String stateInfo;

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

    StateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    public static StateEnum stateOf(int index){
        for(StateEnum state : values()){
            if(state.getState() == index){
                return  state;
            }
        }
        return null;
    }
}
