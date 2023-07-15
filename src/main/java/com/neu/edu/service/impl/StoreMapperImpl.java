package com.neu.edu.service.impl;

import com.neu.edu.mapper.StoreMapper;
import com.neu.edu.service.StoreService;
import com.neu.edu.vo.StoreVO;
import org.springframework.stereotype.Service;
import com.neu.edu.mapper.SaleMapper;
import com.neu.edu.service.SaleService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.SaleVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class StoreMapperImpl implements StoreService {

    @Autowired
    StoreMapper storeMapper;

    /**
     * 查询所有仓库
     */
    @Override
    public ResultModelGet<StoreVO> getAllStoresInfo(){
        ResultModelGet<StoreVO> resultModelGet = new ResultModelGet<StoreVO>();
        List<StoreVO> stores = storeMapper.getAllStoresInfo();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询仓库成功!");
        resultModelGet.setData(stores);
        return resultModelGet;
    }

    /**
     * 按页查询仓库
     * @param page 页数
     * @param size 每页大小
     */
    @Override
    public ResultModelGet<StoreVO> getStoresInfoByPage(int page, int size){
        ResultModelGet<StoreVO> resultModelGet = new ResultModelGet<StoreVO>();
        // 获取总数
        resultModelGet = getAllStoresInfo();
        int sum = resultModelGet.getData().size();
        // 计算页数
        int pageSum = sum / size;
        if (sum % size != 0) {
            pageSum++;
        }
        // 获取指定页数的数据
        if (page > pageSum) { // 页数超过范围
            resultModelGet.setStatus(1);
            resultModelGet.setMessage("页数超过范围!");
            resultModelGet.setData(null);
        } else {
            resultModelGet.setStatus(0);
            resultModelGet.setMessage("查询仓库成功!");
            int dataSize;
            if(page == pageSum) {
                dataSize = sum - (page - 1) * size;
            } else {
                dataSize = size;
            }
            List<StoreVO> stores = resultModelGet.getData().subList((page - 1) * size, (page - 1) * size + dataSize);
            resultModelGet.setData(stores);
        }
        return resultModelGet;
    }

    /**
     * 添加仓库
     * @param storeVO 仓库信息
     */
    @Override
    public ResultModel addStore(StoreVO storeVO){
        ResultModel resultModel = new ResultModel();
        // 判断是否缺乏必要信息
        if (storeVO == null || storeVO.getGoo_goodsNum()== null|| storeVO.getStorageSum() == null || storeVO.getSto_storageNum() == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏必要参数!");
            return resultModel;
        }
        storeMapper.addStore(storeVO);
        resultModel.setStatus(0);
        resultModel.setMessage("添加仓库成功!");
        return resultModel;
    }

    /**
     * 删除仓库
     * @param id 仓库记录编号
     */
    @Override
    public ResultModel deleteStoreById(int id){
        ResultModel resultModel = new ResultModel();
        // 判断id是否存在
        if (storeMapper.getStoreInfoById(id) == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("仓库记录不存在!");
            return resultModel;
        }
        storeMapper.deleteStoreById(id);
        resultModel.setStatus(0);
        resultModel.setMessage("删除仓库成功!");
        return resultModel;
    }

    /**
     * 修改仓库信息
     * @param storeVO 仓库信息 必须包含id
     */
    @Override
    public ResultModel updateStore(StoreVO storeVO){
        ResultModel resultModel = new ResultModel();
        // 判断是否缺乏必要信息
        if (storeVO == null || storeVO.getId() == null|| storeVO.getGoo_goodsNum()== null|| storeVO.getStorageSum() == null || storeVO.getSto_storageNum() == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏必要参数!");
            return resultModel;
        }
        // 判断id是否存在
        if (storeMapper.getStoreInfoById(storeVO.getId()) == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("仓库id:" + storeVO.getId() + "不存在");
            return resultModel;
        }
        storeMapper.updateStore(storeVO);
        resultModel.setStatus(0);
        resultModel.setMessage("修改仓库成功!");
        return resultModel;
    }

    /**
    * 更新存储信息，减少storageSum, 需要提供goo_goodsNum(商品编号), saleNum(销售数量)
    * @param saleVO 存储减少信息
    */
    @Override
    public ResultModel updateStoreBySale(SaleVO saleVO) {
        ResultModel resultModel = new ResultModel();
        // 判断是否缺乏必要信息
        if (saleVO == null || saleVO.getGoo_goodsNum() == null || saleVO.getSaleNum() == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏必要参数!");
            return resultModel;
        }
        // 更新存储信息
        storeMapper.updateStoreBySale(saleVO);
        resultModel.setStatus(0);
        resultModel.setMessage("更新存储信息成功!");
        return resultModel;
    }


}
