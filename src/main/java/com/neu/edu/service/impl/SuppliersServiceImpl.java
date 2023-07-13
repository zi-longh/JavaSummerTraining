package com.neu.edu.service.impl;

import com.neu.edu.mapper.SupplierMapper;
import com.neu.edu.service.SuppliersService;
import com.neu.edu.mapper.StoreMapper;
import com.neu.edu.service.StoreService;
import com.neu.edu.vo.StoreVO;
import com.neu.edu.vo.SupplierVO;
import org.springframework.stereotype.Service;
import com.neu.edu.mapper.SaleMapper;
import com.neu.edu.service.SaleService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.SaleVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SuppliersServiceImpl implements SuppliersService {

    @Autowired
    SupplierMapper supplierMapper;

    /**
     * 查询所有供货商
     */
    @Override
    public ResultModelGet<SupplierVO> getAllSuppliersInfo(){
        ResultModelGet<SupplierVO> resultModelGet = new ResultModelGet<SupplierVO>();
        List<SupplierVO> suppliers = supplierMapper.getAllSuppliersInfo();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询供应商成功!");
        resultModelGet.setData(suppliers);
        return resultModelGet;
    }
    /**
     * 获取供货商编号supplierNum, 用于添加供货商
     */
    @Override
    public ResultModelGet<String> getSupplierNum(){
        ResultModelGet<String> resultModelGet = new ResultModelGet<String>();
        List<String> supplierNums = supplierMapper.getSupplierNum();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询供应商编号成功!");
        resultModelGet.setData(supplierNums);
        return resultModelGet;
    }


    /**
     * 按页查询供货商
     * @param page 页数
     * @param size 每页大小
     */
    @Override
    public ResultModelGet<SupplierVO> getSuppliersInfoByPage(int page, int size){
        ResultModelGet<SupplierVO> resultModelGet = new ResultModelGet<SupplierVO>();
        // 获取总数
        resultModelGet = getAllSuppliersInfo();
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
            if (page == pageSum) { // 最后一页
                dataSize = sum - (page - 1) * size;
            } else {
                dataSize = size;
            }
            List<SupplierVO> suppliers = resultModelGet.getData().subList((page - 1) * size, (page - 1) * size + dataSize);
            resultModelGet.setData(suppliers);
        }
        return resultModelGet;
    }

    /**
     * 添加供货商
     */
    @Override
    public ResultModel addSupplier(SupplierVO supplierVO){
        if(supplierVO == null){
            ResultModel resultModel = new ResultModel();
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏必要参数!");
            return resultModel;
        }

        // 判断是否缺乏必要参数
        if (supplierVO.getSupplierName() == null || supplierVO.getSupplierName().equals("")) {
            ResultModel resultModel = new ResultModel();
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏供应商名称!");
            return resultModel;
        }
        if (supplierVO.getSupplierAddress() == null || supplierVO.getSupplierAddress().equals("")) {
            ResultModel resultModel = new ResultModel();
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏供应商地址!");
            return resultModel;
        }
        if (supplierVO.getSupplierPhone() == null || supplierVO.getSupplierPhone().equals("")) {
            ResultModel resultModel = new ResultModel();
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏供应商电话!");
            return resultModel;
        }

        // 判断是否存在重复供应商(name是否重复)
        SupplierVO supplierVO1 = supplierMapper.getSupplierInfoByName(supplierVO.getSupplierName());
        if (supplierVO1 != null) {
            ResultModel resultModel = new ResultModel();
            resultModel.setStatus(1);
            resultModel.setMessage("供应商名称：" + supplierVO.getSupplierName() + "已存在!");
            return resultModel;
        }

        ResultModel resultModel = new ResultModel();
        supplierMapper.addSupplier(supplierVO);
        resultModel.setStatus(0);
        resultModel.setMessage("添加供应商成功!");
        return resultModel;
    }

    /**
     * 删除供货商
     */
    @Override
    public ResultModel deleteSupplierById(int id){
        ResultModel resultModel = new ResultModel();
        // 判断是否存在该供应商
        SupplierVO supplierVO = supplierMapper.getSupplierInfoById(id);
        if (supplierVO == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("id:" + id + "不存在!");
            return resultModel;
        }
        // 删除供应商
        supplierMapper.deleteSupplierById(id);
        resultModel.setStatus(0);
        resultModel.setMessage("删除供应商成功!");
        return resultModel;
    }

    /**
     * 更新供货商
     * @param supplierVO 供货商信息
     */
    @Override
    public ResultModel updateSupplier(SupplierVO supplierVO) {
        if (supplierVO == null) {
            ResultModel resultModel = new ResultModel();
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏必要参数!");
            return resultModel;
        }

        // 判断是否缺乏必要参数
        if (supplierVO.getSupplierNum() == null) {
            ResultModel resultModel = new ResultModel();
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏供应商id!");
            return resultModel;
        }
        if (supplierVO.getSupplierName() == null || supplierVO.getSupplierName().equals("")) {
            ResultModel resultModel = new ResultModel();
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏供应商名称!");
            return resultModel;
        }
        if (supplierVO.getSupplierAddress() == null || supplierVO.getSupplierAddress().equals("")) {
            ResultModel resultModel = new ResultModel();
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏供应商地址!");
            return resultModel;
        }
        if (supplierVO.getSupplierPhone() == null || supplierVO.getSupplierPhone().equals("")) {
            ResultModel resultModel = new ResultModel();
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏供应商电话!");
            return resultModel;
        }

        // 判断是否存在该供应商
        SupplierVO supplierVO1 = supplierMapper.getSupplierInfoById(supplierVO.getSupplierNum());
        if (supplierVO1 == null) {
            ResultModel resultModel = new ResultModel();
            resultModel.setStatus(1);
            resultModel.setMessage("id:" + supplierVO.getSupplierNum() + "不存在!");
            return resultModel;
        }

        // 更新供应商
        supplierMapper.updateSupplier(supplierVO);
        ResultModel resultModel = new ResultModel();
        resultModel.setStatus(0);
        resultModel.setMessage("更新供应商成功!");
        return resultModel;
    }

}
