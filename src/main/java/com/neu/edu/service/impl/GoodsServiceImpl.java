package com.neu.edu.service.impl;

import com.neu.edu.mapper.GoodsMapper;
import com.neu.edu.service.GoodsService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.utils.ResultModelGetById;
import com.neu.edu.vo.GoodsVO;
import com.neu.edu.vo.VO1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 获取所有商品编号, 结果返回一个List<String>
     */
    @Override
    public ResultModelGet<String> getGoodsNum() {
        ResultModelGet<String> resultModelGet = new ResultModelGet<String>();
        List<String> goodsNum = GoodsMapper.getGoodsNum();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询商品编号成功!");
        resultModelGet.setData(goodsNum);
        return resultModelGet;
    }

    /**
     * 添加商品
     */
    @Override
    public ResultModel addGood(GoodsVO goodsVO){
        ResultModel resultModel = new ResultModel();
        GoodsVO goods = GoodsMapper.getGoodsByName(goodsVO);
        if (goods != null) {
            resultModel.setStatus(1);
            resultModel.setMessage("商品已存在! (goodsNum重复)");
            return resultModel;
        }

        int result = GoodsMapper.addGood(goodsVO);
        if (result == 1) {
            resultModel.setStatus(0);
            resultModel.setMessage("添加商品成功!");
        } else {
            resultModel.setStatus(1);
            resultModel.setMessage("添加商品失败!");
        }
        return resultModel;
    }

    /**
     * 删除商品
     */
    @Override
    public ResultModel deleteGoodById(int id){
        ResultModel resultModel = new ResultModel();
        GoodsVO goodsVO = GoodsMapper.getGoodsById(id);
        if (goodsVO == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("id: " + id + " 的商品不存在!");
            return resultModel;
        }
        int result = GoodsMapper.deleteGoodById(id);
        if (result == 1) {
            resultModel.setStatus(0);
            resultModel.setMessage("删除商品成功!");
        } else {
            resultModel.setStatus(1);
            resultModel.setMessage("删除商品失败!");
        }
        return resultModel;
    }

    /**
     * 更新商品
     */
    @Override
    public ResultModel updateGood(GoodsVO goodsVO){
        ResultModel resultModel = new ResultModel();
        // 判断是否传入了id
        if(goodsVO == null || goodsVO.getGoodsNum() == null){
            resultModel.setStatus(1);
            resultModel.setMessage("参数错误, 未传入id!");
            return resultModel;
        }

        // 判断是否传入了goodsPictureUrl
        if(goodsVO.getGoodsPictureUrl() == null){
            goodsVO.setGoodsPictureUrl("");
        }

        GoodsVO goods = GoodsMapper.getGoodsById(goodsVO.getGoodsNum()); // 通过id查询商品, 判断商品是否存在
        if (goods == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("id: " + goodsVO.getGoodsNum() + " 的商品不存在!");
            return resultModel;
        }
        if(!Objects.equals(goods.getGoodsName(), goodsVO.getGoodsName())){ // 如果修改了商品名称, 则需要判断商品名称是否重复
            GoodsVO goods2 = GoodsMapper.getGoodsByName(goodsVO); // 通过name查询商品, 判断商品是否存在
            if (goods2 != null) {
                resultModel.setStatus(1);
                resultModel.setMessage("商品已存在! (goodsName重复)");
                return resultModel;
            }
        }
        int result = GoodsMapper.updateGood(goodsVO);
        if (result == 1) {
            resultModel.setStatus(0);
            resultModel.setMessage("更新商品成功!");
        } else {
            resultModel.setStatus(1);
            resultModel.setMessage("error, 更新商品失败!");
        }
        return resultModel;
    }

}
