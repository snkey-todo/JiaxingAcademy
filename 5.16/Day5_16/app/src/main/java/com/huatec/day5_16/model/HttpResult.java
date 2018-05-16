package com.huatec.day5_16.model;

/**
 * Created by think on 2018/5/16.
 */

public class HttpResult<T> {
    private int status;
    private String msg;

    @Override
    public String toString() {
        return "HttpResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;
}
