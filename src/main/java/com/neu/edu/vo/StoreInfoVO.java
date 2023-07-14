package com.neu.edu.vo;
/**
 * 用于计算可以入库的数量
 */
public class StoreInfoVO {
    private Integer supplySum;
    private Integer storageSum;
    private Integer availableNum;

    public Integer getSupplySum() {
        return supplySum;
    }

    public void setSupplySum(Integer supplySum) {
        this.supplySum = supplySum;
    }

    public Integer getStorageSum() {
        return storageSum;
    }

    public void setStorageSum(Integer storageSum) {
        this.storageSum = storageSum;
    }

    public Integer getAvailableNum() {
        return availableNum;
    }

    public void setAvailableNum(Integer availableSum) {
        this.availableNum = availableSum;
    }
}
