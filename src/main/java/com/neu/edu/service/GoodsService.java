package com.neu.edu.service;

import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.utils.ResultModelGetById;
import com.neu.edu.vo.GoodsVO;

public interface GoodsService {
    ResultModelGet<GoodsVO> getAllGoodsInfo();
    ResultModel addGood(GoodsVO goodsVO);
    ResultModel deleteGoodById(int id);
    ResultModel updateGood(GoodsVO goodsVO);
    ResultModelGetById<GoodsVO> getGoodsById(int id);
    ResultModelGetById<GoodsVO> getGoodsSumById(int id);

}