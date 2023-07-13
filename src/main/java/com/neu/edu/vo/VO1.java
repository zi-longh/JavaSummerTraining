package com.neu.edu.vo;

// getGoodsNum
public class VO1 {
    /*
    id,
    store.sto_storageNum,
    storageName,
    goo_goodsNum,
    goodsName,
    storageSum
    */
    private Integer id;
    private Integer sto_storageNum;
    private String storageName;
    private Integer goo_goodsNum;
    private String goodsName;
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

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
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

    public Integer getStorageSum() {
        return storageSum;
    }

    public void setStorageSum(Integer storageSum) {
        this.storageSum = storageSum;
    }
}
