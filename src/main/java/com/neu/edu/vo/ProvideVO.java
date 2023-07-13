package com.neu.edu.vo;

public class ProvideVO {
    /*
    属性名           类型
    id              int auto_increment
    sup_supplierNum int  not null,
    goo_goodsNum    int  not null,
    supplierDate    date not null,
    supplierSum     int  not null,
    */

    private Integer id;
    private Integer sup_supplierNum;
    private Integer goo_goodsNum;
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

    public Integer getGoo_goodsNum() {
        return goo_goodsNum;
    }

    public void setGoo_goodsNum(Integer goo_goodsNum) {
        this.goo_goodsNum = goo_goodsNum;
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

    @Override
    public String toString() {
        return "ProvideVO{" +
                "id=" + id +
                ", sup_supplierNum=" + sup_supplierNum +
                ", goo_goodsNum=" + goo_goodsNum +
                ", supplierDate='" + supplierDate + '\'' +
                ", supplierSum=" + supplierSum +
                '}';
    }
}
