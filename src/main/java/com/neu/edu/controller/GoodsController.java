package com.neu.edu.controller;
import com.neu.edu.service.GoodsService;
import com.neu.edu.utils.JWTUtil;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.utils.ResultModelGetById;
import com.neu.edu.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @GetMapping(value = "/getAllGoodsInfo")
    public ResultModelGet<GoodsVO> getGoods() {
        return goodsService.getAllGoodsInfo();
    }
    @GetMapping(value = "/getGoodsById/{id}")
    public ResultModelGetById<GoodsVO> getGoodsById(@PathVariable("id") int id) {
        return goodsService.getGoodsById(id);
    }

    /**
     * 获取商品编号goodsNum, 返回一个list
     */
    @GetMapping(value = "/getGoodsNum")
    public ResultModelGet<String> getGoodsNum() {
        return goodsService.getGoodsNum();
    }


    @PostMapping(value = "/addGood")
    public ResultModel addGood(GoodsVO goodsVO) {
        return goodsService.addGood(goodsVO);
    }

    @DeleteMapping(value = "/deleteGoodById/{id}")
    public ResultModel deleteGoodsById(@PathVariable("id") int id) {
        return goodsService.deleteGoodById(id);
    }

    /**
     * 更新商品信息
     * @param goodsVO 商品信息 必须传入id
     */
    @PutMapping(value = "/updateGood")
    public ResultModel updateGoods(@RequestBody GoodsVO goodsVO) {
        return goodsService.updateGood(goodsVO);
    }

    // todo: 2021/7/27 该接口未实现！
    @GetMapping(value = "/getGoodsSumById/{id}")
    public ResultModelGetById<GoodsVO> getGoodsSumById(@PathVariable("id") int id) {
        return goodsService.getGoodsSumById(id);
    }
}





