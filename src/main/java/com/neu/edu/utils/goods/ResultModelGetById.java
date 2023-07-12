package com.neu.edu.utils.goods;

import java.util.List;

public class ResultModelGetById<T> {
    /*
    status: 0表示成功，1表示失败
    message: '查询成功！',
    data:[{},{}]
    */
    private int status;
    private String message;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
