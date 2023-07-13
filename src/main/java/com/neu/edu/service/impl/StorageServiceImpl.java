package com.neu.edu.service.impl;

import com.neu.edu.mapper.StorageMapper;
import com.neu.edu.service.StorageService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.StorageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    /**
     * 获取全部库存信息
     */
    @Override
    public ResultModelGet<StorageVO> getAllStoragesInfo(){
        ResultModelGet<StorageVO> resultModelGet = new ResultModelGet<StorageVO>();
        List<StorageVO> storage = storageMapper.getAllStoragesInfo();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询库存成功!");
        resultModelGet.setData(storage);
        resultModelGet.setDataTotal(storage.size());
        return resultModelGet;
    }

    /**
     * 按页获取库存信息
     * @param page 页数
     * @param size 每页大小
     */
    @Override
    public ResultModelGet<StorageVO> getStoragesInfoByPage(int page, int size){
        ResultModelGet<StorageVO> resultModelGet = new ResultModelGet<>();
        resultModelGet = getAllStoragesInfo();
        // 按照每页大小划分库存数据，按页返回库存数据
        int dataTotal = resultModelGet.getDataTotal();
        int pageTotal = dataTotal / size;
        if (dataTotal % size != 0) {
            pageTotal += 1;
        }
        if (page > pageTotal) {
            resultModelGet.setStatus(1);
            resultModelGet.setMessage("参数错误(超出页数范围), 查询库存失败!");
            resultModelGet.setData(null);
        } else {
            resultModelGet.setStatus(0);
            resultModelGet.setMessage("查询库存成功!");
            resultModelGet.setDataTotal(size);
            resultModelGet.setData(resultModelGet.getData().subList((page - 1) * size, Math.min(page * size, dataTotal)));
        }
        return resultModelGet;
    }

    /**
     * 添加库存信息
     * @param storageVO 库存信息
     */
    @Override
    public ResultModel addStorage(StorageVO storageVO){
        ResultModel resultModel = new ResultModel();
        // 判断是否缺乏必要参数
        if( storageVO == null || storageVO.getStorageAddress()==null || storageVO.getStorageName()==null) {
            resultModel.setStatus(1);
            resultModel.setMessage("参数错误(缺乏必要参数), 添加库存失败!");
            return resultModel;
        }
        // 如果传入了库存编号，判断库存是否存在
        if(storageVO.getStorageNum() != null){
            StorageVO storage = storageMapper.getStorageInfoById(storageVO.getStorageNum());
            if(storage != null){
                resultModel.setStatus(1);
                resultModel.setMessage("库存：" + storageVO.getStorageNum() + "已存在, 添加库存失败!");
                return resultModel;
            }
            // 添加库存
            storageMapper.addStorage(storageVO);
        }else{
            // 添加库存
            storageMapper.addStorageWithoutId(storageVO); // 无库存编号方式添加库存
        }
        resultModel.setStatus(0);
        resultModel.setMessage("添加库存成功!");
        return resultModel;
    }

    /**
     * 删除库存信息
     * @param storageNum 库存编号
     */
    @Override
    public ResultModel deleteStorageById(int storageNum){
        ResultModel resultModel = new ResultModel();
        // 判断库存是否存在
        StorageVO storage = storageMapper.getStorageInfoById(storageNum);
        if(storage == null){
            resultModel.setStatus(1);
            resultModel.setMessage("库存：" + storageNum + "不存在, 删除库存失败!");
            return resultModel;
        }
        // 删除库存
        storageMapper.deleteStorageById(storageNum);
        resultModel.setStatus(0);
        resultModel.setMessage("删除库存成功!");
        return resultModel;
    }

    /**
     * 更新库存信息
     * @param storageVO 库存信息
     */
    @Override
    public ResultModel updateStorage(StorageVO storageVO){
        ResultModel resultModel = new ResultModel();
        // 判断是否缺乏必要参数
        if( storageVO == null || storageVO.getStorageNum()==null || storageVO.getStorageAddress()==null || storageVO.getStorageName()==null) {
            resultModel.setStatus(1);
            resultModel.setMessage("参数错误(缺乏必要参数), 更新库存失败!");
            return resultModel;
        }
        // 判断库存是否存在
        StorageVO storage = storageMapper.getStorageInfoById(storageVO.getStorageNum());
        if(storage == null){
            resultModel.setStatus(1);
            resultModel.setMessage("库存：" + storageVO.getStorageNum() + "不存在, 更新库存失败!");
            return resultModel;
        }
        // 更新库存
        storageMapper.updateStorage(storageVO);
        resultModel.setStatus(0);
        resultModel.setMessage("更新库存成功!");
        return resultModel;
    }

    /**
     * 获取库存StorageNum
     */
    @Override
    public ResultModelGet<String> getStoragesNum() {
        ResultModelGet<String> resultModelGet = new ResultModelGet<>();
        List<String> storagesNum = storageMapper.getStoragesNum();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询库存编号成功!");
        resultModelGet.setData(storagesNum);
        resultModelGet.setDataTotal(storagesNum.size());
        return resultModelGet;
    }


}
