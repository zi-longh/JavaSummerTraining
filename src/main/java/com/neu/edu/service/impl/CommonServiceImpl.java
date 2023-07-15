package com.neu.edu.service.impl;

import com.neu.edu.mapper.CommonMapper;
import com.neu.edu.service.CommonService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.utils.ResultModelGetById;
import com.neu.edu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    CommonMapper commonMapper;

    @Override
    public ResultModelGet<VO1> getInfo1(){
        ResultModelGet<VO1> resultModelGet = new ResultModelGet<VO1>();
        List<VO1> vo1 = commonMapper.getInfo1();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询成功!");
        resultModelGet.setData(vo1);
        return resultModelGet;
    }

    @Override
    public ResultModelGet<VO2> getInfo2(){
        ResultModelGet<VO2> resultModelGet = new ResultModelGet<VO2>();
        List<VO2> vo2 = commonMapper.getInfo2();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询成功!");
        resultModelGet.setData(vo2);
        return resultModelGet;
    }

    @Override
    public ResultModelGet<VO3> getInfo3(){
        ResultModelGet<VO3> resultModelGet = new ResultModelGet<VO3>();
        List<VO3> vo3 = commonMapper.getInfo3();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询成功!");
        resultModelGet.setData(vo3);
        return resultModelGet;
    }

    /**
     * 获取可入库数量
     */
    @Override
    public ResultModelGetById<StoreInfoVO> getAvailableNum(StoreVO storeVO) {
        ResultModelGetById<StoreInfoVO> resultModelGetById = new ResultModelGetById<StoreInfoVO>();
        // 判断是否缺乏必要参数goo_goodsNum
        if(storeVO.getGoo_goodsNum() == null ){
            resultModelGetById.setStatus(1);
            resultModelGetById.setMessage("缺乏必要参数goo_goodsNum 查询失败!");
            resultModelGetById.setData(null);
            return resultModelGetById;
        }

        StoreInfoVO storeInfoVO = commonMapper.getAvailableNum(storeVO);
        if (storeInfoVO == null) {
            resultModelGetById.setStatus(1);
            resultModelGetById.setMessage("查询失败!没有数据!");
            resultModelGetById.setData(null);
        } else {
            resultModelGetById.setStatus(0);
            resultModelGetById.setMessage("查询成功!");
            resultModelGetById.setData(storeInfoVO);
        }
        return resultModelGetById;
    }

    /**
     * 完成清除购物车的操作 （收银操作）
     */
    @Override
    public ResultModel sellGoods(List<SaleVO> saleVOList,String saleTime, Integer workerNum) {
        if(saleVOList == null || saleVOList.size() == 0){
            ResultModel resultModel = new ResultModel();
            resultModel.setStatus(1);
            resultModel.setMessage("saleVOList为空!,saleTime:"+saleTime+",workerNum:"+workerNum);
            return resultModel;
        }

        for (SaleVO saleVO : saleVOList) {
            saleVO.setSaleTime(saleTime);
            saleVO.setEmp_workerNum(workerNum);
            System.out.println(saleVO);

            commonMapper.sellGoodsAddSale(saleVO);
            commonMapper.sellGoodsUpdateStore(saleVO);
        }
        ResultModel resultModel = new ResultModel();
        resultModel.setStatus(0);
        resultModel.setMessage("清空购物车成功!");
        return resultModel;
    }
}
