package com.neu.edu.service.impl;

import com.neu.edu.mapper.GoodsMapper;
import com.neu.edu.service.GoodsService;
import com.neu.edu.utils.goods.ResultModelGet;
import com.neu.edu.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper GoodsMapper;

    @Override
    public ResultModelGet<GoodsVO> getAllGoodsInfo(){
        ResultModelGet<GoodsVO> resultModelGet = new ResultModelGet<GoodsVO>();
        List<GoodsVO> goods = GoodsMapper.getAllGoodsInfo();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询商品成功");
        resultModelGet.setData(goods);
        return resultModelGet;
    }
}
