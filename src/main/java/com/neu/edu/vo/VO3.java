package com.neu.edu.vo;

// getSaleNum
public class VO3 {
    /*
        id,
        sale.emp_workerNum,
        name,
        goo_goodsNum,
        goodsName,
        saleTime,
        saleNum
    */
    private Integer id;
    private Integer emp_workerNum;
    private String name;
    private Integer goo_goodsNum;
    private String goodsName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoo_goodsNum() {
        return goo_goodsNum;
    }

    public void setGoo_goodsNum(Integer goo_goodsNum) {
        this.goo_goodsNum = goo_goodsNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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
