package com.neu.edu.service.impl;

import com.neu.edu.mapper.SaleMapper;
import com.neu.edu.service.SaleService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.SaleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleMapper saleMapper;

    /**
     * 查询总销售记录
     */
    @Override
    public ResultModelGet<SaleVO> getAllSalesInfo(){
        ResultModelGet<SaleVO> resultModelGet = new ResultModelGet<SaleVO>();
        resultModelGet.setData(saleMapper.getAllSalesInfo());
        resultModelGet.setDataTotal(resultModelGet.getData().size());
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询销售记录成功!");
        return resultModelGet;
    }

    /**
     * 按页查询销售记录
     * @param page 页数
     * @param size 每页大小
     */
    @Override
    public ResultModelGet<SaleVO> getSalesInfoByPage(int page, int size){
        ResultModelGet<SaleVO> resultModelGet = new ResultModelGet<>();
        resultModelGet = getAllSalesInfo();
        // 按照每页大小划分销售记录数据，按页返回销售记录数据
        int dataTotal = resultModelGet.getDataTotal();
        int pageTotal = dataTotal / size;
        if (dataTotal % size != 0) {
            pageTotal += 1;
        }
        if (page > pageTotal) {
            resultModelGet.setStatus(1);
            resultModelGet.setMessage("参数错误(超出页数范围), 查询销售记录失败!");
            resultModelGet.setData(null);
        } else {
            resultModelGet.setStatus(0);
            resultModelGet.setMessage("查询销售记录成功!");
            resultModelGet.setDataTotal(size);
            resultModelGet.setData(resultModelGet.getData().subList((page - 1) * size, Math.min(page * size, dataTotal)));
        }
        return resultModelGet;
    }

    /**
     * 添加销售记录
     * @param saleVO 销售记录
     */
    @Override
    public ResultModel addSale(SaleVO saleVO){
        ResultModel resultModel = new ResultModel();
        // 判断是否缺乏必要参数
        if(saleVO == null || saleVO.getSaleNum()==null || saleVO.getEmp_workerNum()==null || saleVO.getSaleTime()==null || saleVO.getGoo_goodsNum() == null ){
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏必要参数, 添加销售记录失败!");
            return resultModel;
        }
        // 判断是否传入了id
        if(saleVO.getId() != null){
            // 传入了id, 判断id是否存在
            if(saleMapper.getSaleInfoById(saleVO.getId()) != null){
                // id存在, 添加失败
                resultModel.setStatus(1);
                resultModel.setMessage("id: " + saleVO.getId() + " 已存在, 添加销售记录失败!");
            }else{
                // id不存在, 添加销售记录
                saleMapper.addSale(saleVO);
                resultModel.setStatus(0);
                resultModel.setMessage("添加销售记录成功!");
            }
        }else{
            // 未传入id, 添加销售记录
            saleMapper.addSaleWithoutId(saleVO);
            resultModel.setStatus(0);
            resultModel.setMessage("添加销售记录成功!");
        }
        return resultModel;
    }

    /**
     * 删除销售记录
     * @param id 销售记录id
     */
    @Override
    public ResultModel deleteSaleById(int id){
        ResultModel resultModel = new ResultModel();
        // 判断id是否存在
        if(saleMapper.getSaleInfoById(id) == null){
            // id不存在, 删除失败
            resultModel.setStatus(1);
            resultModel.setMessage("id: " + id + " 不存在, 删除销售记录失败!");
        }else{
            // id存在, 删除销售记录
            saleMapper.deleteSaleById(id);
            resultModel.setStatus(0);
            resultModel.setMessage("删除销售记录成功!");
        }
        return resultModel;
    }

    /**
     * 更新销售记录
     * @param saleVO 销售记录
     */
    @Override
    public ResultModel updateSale(SaleVO saleVO){
        ResultModel resultModel = new ResultModel();
        // 判断是否缺乏必要参数
        if(saleVO == null || saleVO.getId()==null || saleVO.getSaleNum()==null || saleVO.getEmp_workerNum()==null || saleVO.getSaleTime()==null || saleVO.getGoo_goodsNum() == null ){
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏必要参数, 更新销售记录失败!");
            return resultModel;
        }
        // 判断id是否存在
        if(saleMapper.getSaleInfoById(saleVO.getId()) == null){
            // id不存在, 更新失败
            resultModel.setStatus(1);
            resultModel.setMessage("id: " + saleVO.getId() + " 不存在, 更新销售记录失败!");
        }else{
            // id存在, 更新销售记录
            saleMapper.updateSale(saleVO);
            resultModel.setStatus(0);
            resultModel.setMessage("更新销售记录成功!");
        }
        return resultModel;
    }

}

