package com.neu.edu.vo;

public class SaleVO {
    /*
    属性名         数据库字段名
    id            int auto_increment
    emp_workerNum int  not null,
    goo_goodsNum  int  not null,
    saleTime      date not null,
    saleNum       int  not null,
    */
    private Integer id;
    private Integer emp_workerNum;
    private Integer goo_goodsNum;
    private String saleTime;
    private Integer saleNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmp_workerNum() {
        return emp_workerNum;
    }

    public void setEmp_workerNum(Integer emp_workerNum) {
        this.emp_workerNum = emp_workerNum;
    }

    public Integer getGoo_goodsNum() {
        return goo_goodsNum;
    }

    public void setGoo_goodsNum(Integer goo_goodsNum) {
        this.goo_goodsNum = goo_goodsNum;
    }

    public String getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(String saleTime) {
        this.saleTime = saleTime;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }
}
