package com.neu.edu.service;

import com.neu.edu.utils.goods.ResultModelGet;
import com.neu.edu.utils.goods.ResultModelGetById;
import com.neu.edu.utils.goods.ResultModelUpdate;
import com.neu.edu.vo.GoodsVO;

public interface GoodsService {
    ResultModelGet<GoodsVO> getAllGoodsInfo();
    ResultModelUpdate addGood(GoodsVO goodsVO);
    ResultModelUpdate deleteGoodById(int id);
    ResultModelUpdate updateGood(GoodsVO goodsVO);
    ResultModelGetById<GoodsVO> getGoodsById(int id);
    ResultModelGetById<GoodsVO> getGoodsSumById(int id);

}
