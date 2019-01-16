package com.chao.seckill.dto;

public class CommonResult<T> {

    private boolean status;

    private T data;

    private String message;

    public CommonResult(boolean status, T data) {
        this.status = status;
        this.data = data;
    }

    public CommonResult(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
