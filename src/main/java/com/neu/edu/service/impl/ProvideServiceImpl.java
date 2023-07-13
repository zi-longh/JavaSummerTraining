package com.neu.edu.service.impl;

import com.neu.edu.mapper.ProvideMapper;
import com.neu.edu.service.ProvideService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.ProvideVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvideServiceImpl implements ProvideService {

    @Autowired
    ProvideMapper provideMapper;

    /**
     * 查询所有供应商
     */
    @Override
    public ResultModelGet<ProvideVO> getAllProvidesInfo(){
        ResultModelGet<ProvideVO> resultModelGet = new ResultModelGet<ProvideVO>();
        List<ProvideVO> provides = provideMapper.getAllProvidesInfo();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询供应商成功!");
        resultModelGet.setData(provides);
        return resultModelGet;
    }

    /**
     * 按页查询供应商
     * @param page 页数
     * @param size 每页大小
     */
    @Override
    public ResultModelGet<ProvideVO> getProvidesInfoByPage(int page, int size){
        ResultModelGet<ProvideVO> resultModelGet = new ResultModelGet<ProvideVO>();
        // 获取总数
        resultModelGet = getAllProvidesInfo();
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
            resultModelGet.setMessage("查询供应商成功!");
            int dataSize;
            if(page == pageSum) {
                dataSize = sum - (page - 1) * size;
            } else {
                dataSize = size;
            }
            resultModelGet.setDataTotal(dataSize);
            resultModelGet.setData(resultModelGet.getData().subList((page - 1) * size, (page - 1) * size + dataSize));
        }
        return resultModelGet;
    }

    /**
     * 添加供应商
     * @param provideVO 供应商信息
     */
    @Override
    public ResultModel addProvide(ProvideVO provideVO){
        ResultModel resultModel = new ResultModel();
        System.out.println(provideVO.toString());
        // 判断是否缺乏必要信息（可以不用含有id）
        if(provideVO == null || provideVO.getGoo_goodsNum() == null || provideVO.getSup_supplierNum() == null || provideVO.getSupplierDate() == null){
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏必要信息!");
            return resultModel;
        }
        // 添加供应商
        provideMapper.addProvide(provideVO);
        resultModel.setStatus(0);
        resultModel.setMessage("添加供应商成功!");
        return resultModel;
    }

    /**
     * 按照id删除供应商
     * @param provideNum 供应商id
     */
    @Override
    public ResultModel deleteProvideById(int provideNum){
        ResultModel resultModel = new ResultModel();
        // 判断id是否存在
        if(provideMapper.getProvideInfoById(provideNum) == null){
            resultModel.setStatus(1);
            resultModel.setMessage("id不存在!");
            return resultModel;
        }
        // 删除供应商
        provideMapper.deleteProvideById(provideNum);
        resultModel.setStatus(0);
        resultModel.setMessage("删除供应商成功!");
        return resultModel;
    }

    /**
     * 更新供应商信息
     * @param provideVO 供应商信息 必须提供id
     */
    public ResultModel updateProvide(ProvideVO provideVO){
        ResultModel resultModel = new ResultModel();
        // 判断是否缺乏必要信息
        if(provideVO == null || provideVO.getId() == null || provideVO.getGoo_goodsNum() == null || provideVO.getSup_supplierNum() == null || provideVO.getSupplierDate() == null){
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏必要信息!");
            return resultModel;
        }
        // 判断id是否存在
        if(provideMapper.getProvideInfoById(provideVO.getId()) == null){
            resultModel.setStatus(1);
            resultModel.setMessage("id:" + provideVO.getId() + "不存在!");
            return resultModel;
        }
        // 更新供应商信息
        provideMapper.updateProvide(provideVO);
        resultModel.setStatus(0);
        resultModel.setMessage("更新供应商信息成功!");
        return resultModel;
    }

}
