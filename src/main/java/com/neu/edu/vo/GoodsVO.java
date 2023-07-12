package com.neu.edu.vo;

public class GoodsVO {
    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Double getGoodsCost() {
        return goodsCost;
    }

    public void setGoodsCost(Double goodsCost) {
        this.goodsCost = goodsCost;
    }

    /* goodsNum、goodsName、goodsType、goodsPrice、goodsCost */
    private Integer goodsNum;
    private String goodsName;
    private String goodsType;
    private Double goodsPrice;
    private Double goodsCost;

    /* 重写toString */
    @Override
    public String toString() {
        return "GoodsVO{" +
                "goodsNum=" + goodsNum +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsCost=" + goodsCost +
                '}';
    }

}
