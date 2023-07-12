package com.neu.edu.controller;
import com.neu.edu.service.GoodsService;
import com.neu.edu.service.impl.GoodsServiceImpl;
import com.neu.edu.utils.goods.ResultModelGet;
import com.neu.edu.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @GetMapping(value = "/goods/getAllGoodsInfo")
    public ResultModelGet<GoodsVO> getGoods() {
        ResultModelGet<GoodsVO> resultModelGet = new ResultModelGet<>();
        resultModelGet = goodsService.getAllGoodsInfo();
        return resultModelGet;
    }
}





