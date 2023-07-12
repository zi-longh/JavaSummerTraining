package com.neu.edu.utils.goods;

import java.util.List;

public class ResultModelGet<T> {
    /*
    status: 0表示成功，1表示失败
    message: '查询成功！',
    dataTotal:xxx; 表示查询到的条数
    data:[{},{}]
    */
    private int status;
    private String message;
    private int dataTotal;
    private List<T> data;

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

    public int getDataTotal() {
        return dataTotal;
    }

    public void setDataTotal(int dataTotal) {
        this.dataTotal = dataTotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.dataTotal = data.size();
        this.data = data;
    }
}
