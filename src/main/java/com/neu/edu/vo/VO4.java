package com.neu.edu.vo;

import java.util.List;

public class VO4 {
    private String saleTime;
    private List<SaleVO> saleVOList; // 存储商品编号和销售数量

    public String getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(String saleTime) {
        this.saleTime = saleTime;
    }

    public List<SaleVO> getSaleVOList() {
        return saleVOList;
    }

    public void setSaleVOList(List<SaleVO> saleVOList) {
        this.saleVOList = saleVOList;
    }
}
