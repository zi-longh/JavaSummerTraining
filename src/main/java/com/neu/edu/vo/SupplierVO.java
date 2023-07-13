package com.neu.edu.vo;

public class SuppliersVO {
    /*
    属性名
    supplierNum          int ,
    supplierName         varchar(20),
    supplierAddress      varchar(100),
    supplierPhone        varchar(11),
    */
    private String supplierNum;
    private String supplierName;
    private String supplierAddress;
    private String supplierPhone;

    public String getSupplierNum() {
        return supplierNum;
    }

    public void setSupplierNum(String supplierNum) {
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
