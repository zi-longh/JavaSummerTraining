package com.neu.edu.controller;
import com.neu.edu.service.GoodsService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.utils.ResultModelGetById;
import com.neu.edu.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResultModel addGood(@RequestBody GoodsVO goodsVO) {
//        System.out.println(goodsVO.getGoodsName());
        return goodsService.addGood(goodsVO);
    }

    @DeleteMapping(value = "/goods/deleteGoodById/{id}")
    public ResultModel deleteGoodsById(@PathVariable("id") int id) {
        return goodsService.deleteGoodById(id);
    }

    @PutMapping(value = "/goods/updateGood")
    public ResultModel updateGoods(@RequestBody GoodsVO goodsVO) {
        return goodsService.updateGood(goodsVO);
    }




}





