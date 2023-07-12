package com.neu.edu.service.impl;

import com.neu.edu.mapper.GoodsMapper;
import com.neu.edu.service.GoodsService;
import com.neu.edu.utils.goods.ResultModelGet;
import com.neu.edu.utils.goods.ResultModelGetById;
import com.neu.edu.utils.goods.ResultModelUpdate;
import com.neu.edu.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.List;
import java.util.Objects;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper GoodsMapper;

    /**
     * 获取所有商品信息
     */
    @Override
    public ResultModelGet<GoodsVO> getAllGoodsInfo(){
        ResultModelGet<GoodsVO> resultModelGet = new ResultModelGet<GoodsVO>();
        List<GoodsVO> goods = GoodsMapper.getAllGoodsInfo();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询商品成功!");
        resultModelGet.setData(goods);
        return resultModelGet;
    }

    /**
    * 按照id查询商品信息
    */
    @Override
    public ResultModelGetById<GoodsVO> getGoodsById(int id) {
        ResultModelGetById<GoodsVO> resultModelGetById = new ResultModelGetById<GoodsVO>();
        GoodsVO goodsVO = GoodsMapper.getGoodsById(id);
        if (goodsVO != null) {
            resultModelGetById.setStatus(0);
            resultModelGetById.setMessage("查询商品成功!");
            resultModelGetById.setData(goodsVO);
        } else {
            resultModelGetById.setStatus(1);
            resultModelGetById.setMessage("参数错误, 查询商品失败!");
            resultModelGetById.setData(null);
        }
        System.out.println(resultModelGetById.getData());
        return resultModelGetById;
    }

    /**
     * 查询商品总数
     */
    @Override
    public ResultModelGetById<GoodsVO> getGoodsSumById(int id){
        return getGoodsById(id);
    }

    /**
     * 添加商品
     */
    @Override
    public ResultModelUpdate addGood(GoodsVO goodsVO){
        ResultModelUpdate resultModelUpdate = new ResultModelUpdate();
        GoodsVO goods = GoodsMapper.getGoodsByName(goodsVO);
        if (goods != null) {
            resultModelUpdate.setStatus(1);
            resultModelUpdate.setMessage("商品已存在! (goodsNum重复)");
            return resultModelUpdate;
        }

        int result = GoodsMapper.addGood(goodsVO);
        if (result == 1) {
            resultModelUpdate.setStatus(0);
            resultModelUpdate.setMessage("添加商品成功!");
        } else {
            resultModelUpdate.setStatus(1);
            resultModelUpdate.setMessage("添加商品失败!");
        }
        return resultModelUpdate;
    }

    /**
     * 删除商品
     */
    @Override
    public ResultModelUpdate deleteGoodById(int id){
        ResultModelUpdate resultModelUpdate = new ResultModelUpdate();
        GoodsVO goodsVO = GoodsMapper.getGoodsById(id);
        if (goodsVO == null) {
            resultModelUpdate.setStatus(1);
            resultModelUpdate.setMessage("id: " + id + " 的商品不存在!");
            return resultModelUpdate;
        }
        int result = GoodsMapper.deleteGoodById(id);
        if (result == 1) {
            resultModelUpdate.setStatus(0);
            resultModelUpdate.setMessage("删除商品成功!");
        } else {
            resultModelUpdate.setStatus(1);
            resultModelUpdate.setMessage("删除商品失败!");
        }
        return resultModelUpdate;
    }

    /**
     * 更新商品
     */
    @Override
    public ResultModelUpdate updateGood(GoodsVO goodsVO){
        ResultModelUpdate resultModelUpdate = new ResultModelUpdate();
        GoodsVO goods = GoodsMapper.getGoodsById(goodsVO.getGoodsNum()); // 通过id查询商品, 判断商品是否存在
        if (goods == null) {
            resultModelUpdate.setStatus(1);
            resultModelUpdate.setMessage("id: " + goodsVO.getGoodsNum() + " 的商品不存在!");
            return resultModelUpdate;
        }
        if(!Objects.equals(goods.getGoodsName(), goodsVO.getGoodsName())){ // 如果修改了商品名称, 则需要判断商品名称是否重复
            GoodsVO goods2 = GoodsMapper.getGoodsByName(goodsVO); // 通过name查询商品, 判断商品是否存在
            if (goods2 != null) {
                resultModelUpdate.setStatus(1);
                resultModelUpdate.setMessage("商品已存在! (goodsName重复)");
                return resultModelUpdate;
            }
        }
        int result = GoodsMapper.updateGood(goodsVO);
        if (result == 1) {
            resultModelUpdate.setStatus(0);
            resultModelUpdate.setMessage("更新商品成功!");
        } else {
            resultModelUpdate.setStatus(1);
            resultModelUpdate.setMessage("error, 更新商品失败!");
        }
        return resultModelUpdate;
    }

}
