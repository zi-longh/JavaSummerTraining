package com.neu.edu.controller;
import com.neu.edu.service.GoodsService;
import com.neu.edu.service.impl.GoodsServiceImpl;
import com.neu.edu.utils.goods.ResultModelGet;
import com.neu.edu.utils.goods.ResultModelGetById;
import com.neu.edu.utils.goods.ResultModelUpdate;
import com.neu.edu.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @GetMapping(value = "/goods/getAllGoodsInfo")
    public ResultModelGet<GoodsVO> getGoods() {
        return goodsService.getAllGoodsInfo();
    }
    @GetMapping(value = "/goods/getGoodsById/{id}")
    public ResultModelGetById<GoodsVO> getGoodsById(@PathVariable("id") int id) {
        return goodsService.getGoodsById(id);
    }
    @GetMapping(value = "/goods/getGoodsSumById/{id}")
    public ResultModelGetById<GoodsVO> getGoodsSumById(@PathVariable("id") int id) {
        return goodsService.getGoodsSumById(id);
    }

    @PostMapping(value = "/goods/addGood")
    public ResultModelUpdate addGood(GoodsVO goodsVO) {
//        System.out.println(goodsVO.getGoodsName());
        return goodsService.addGood(goodsVO);
    }

    @DeleteMapping(value = "/goods/deleteGoodById/{id}")
    public ResultModelUpdate deleteGoodsById(@PathVariable("id") int id) {
        return goodsService.deleteGoodById(id);
    }

    @PutMapping(value = "/goods/updateGood")
    public ResultModelUpdate updateGoods(GoodsVO goodsVO) {
        return goodsService.updateGood(goodsVO);
    }




}





