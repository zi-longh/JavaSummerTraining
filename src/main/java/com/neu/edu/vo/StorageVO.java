package com.neu.edu.vo;

public class StorageVO {
    /*
    属性名         数据库字段类型
    storageNum     int
    storageName    varchar(20) null,
    storageAddress varchar(40) null
    */

    public Integer getStorageNum() {
        return storageNum;
    }

    public void setStorageNum(Integer storageNum) {
        this.storageNum = storageNum;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageAddress() {
        return storageAddress;
    }

    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }

    private Integer storageNum;
    private String storageName;
    private String storageAddress;

}
