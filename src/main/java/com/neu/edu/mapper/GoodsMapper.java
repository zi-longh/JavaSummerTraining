package com.neu.edu.mapper;

import com.neu.edu.vo.GoodsVO;
import com.neu.edu.vo.VO1;

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
    ResultModel addGood(GoodsVO goodsVO);
    ResultModel deleteGoodById(int id);
    ResultModel updateGood(GoodsVO goodsVO);
    ResultModelGetById<GoodsVO> getGoodsById(int id);
    ResultModelGetById<GoodsVO> getGoodsSumById(int id);
    */
}
