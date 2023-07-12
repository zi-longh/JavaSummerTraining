package com.neu.edu.service;

import com.neu.edu.utils.goods.ResultModelGet;
import com.neu.edu.vo.GoodsVO;

public interface GoodsService {
    ResultModelGet<GoodsVO> getAllGoodsInfo();
}
