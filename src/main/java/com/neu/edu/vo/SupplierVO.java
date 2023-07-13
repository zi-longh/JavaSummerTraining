package com.neu.edu.vo;

public class SupplierVO {
    /*
    属性名
    supplierNum          int ,
    supplierName         varchar(20),
    supplierAddress      varchar(100),
    supplierPhone        varchar(11),
    */
    private Integer supplierNum;
    private String supplierName;
    private String supplierAddress;
    private String supplierPhone;

    public Integer getSupplierNum() {
        return supplierNum;
    }

    public void setSupplierNum(Integer supplierNum) {
        this.supplierNum = supplierNum;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }
}
