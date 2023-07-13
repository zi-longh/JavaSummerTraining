package com.neu.edu.vo;

// getStoragesNum
public class VO2 {
/*
    id,
    sup_supplierNum,
    supplierName,
    goo_goodsNum,
    goodsName,
    supplierDate,
    supplierSum
*/
    private Integer id;
    private Integer sup_supplierNum;
    private String supplierName;
    private Integer goo_goodsNum;
    private String goodsName;
    private String supplierDate;
    private Integer supplierSum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSup_supplierNum() {
        return sup_supplierNum;
    }

    public void setSup_supplierNum(Integer sup_supplierNum) {
        this.sup_supplierNum = sup_supplierNum;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

    public String getSupplierDate() {
        return supplierDate;
    }

    public void setSupplierDate(String supplierDate) {
        this.supplierDate = supplierDate;
    }

    public Integer getSupplierSum() {
        return supplierSum;
    }

    public void setSupplierSum(Integer supplierSum) {
        this.supplierSum = supplierSum;
    }
}
