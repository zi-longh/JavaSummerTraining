package com.neu.edu.vo;

public class StoreVO {
    /*
    属性名         类型
    id             int auto_increment
    sto_storageNum int    not null,
    goo_goodsNum   int    not null,
    storageSum     bigint not null,
    */

    private Integer id;
    private Integer sto_storageNum;
    private Integer goo_goodsNum;
    private Integer storageSum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSto_storageNum() {
        return sto_storageNum;
    }

    public void setSto_storageNum(Integer sto_storageNum) {
        this.sto_storageNum = sto_storageNum;
    }

    public Integer getGoo_goodsNum() {
        return goo_goodsNum;
    }

    public void setGoo_goodsNum(Integer goo_goodsNum) {
        this.goo_goodsNum = goo_goodsNum;
    }

    public Integer getStorageSum() {
        return storageSum;
    }

    public void setStorageSum(Integer storageSum) {
        this.storageSum = storageSum;
    }
}
