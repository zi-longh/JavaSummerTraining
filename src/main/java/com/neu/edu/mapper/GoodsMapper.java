package com.neu.edu.mapper;

import com.neu.edu.vo.GoodsVO;

import java.util.List;

public interface GoodsMapper {

    List<GoodsVO> getAllGoodsInfo();
    GoodsVO getGoodsById(Integer goodsNum);
    GoodsVO getGoodsByName(GoodsVO goodsVO);
    int addGood(GoodsVO goodsVO);
    int deleteGoodById(Integer goodsNum);
    int updateGood(GoodsVO goodsVO);

    /*
    ResultModelGet<GoodsVO> getAllGoodsInfo();
    ResultModelUpdate addGood(GoodsVO goodsVO);
    ResultModelUpdate deleteGoodById(int id);
    ResultModelUpdate updateGood(GoodsVO goodsVO);
    ResultModelGetById<GoodsVO> getGoodsById(int id);
    ResultModelGetById<GoodsVO> getGoodsSumById(int id);
    */
}
