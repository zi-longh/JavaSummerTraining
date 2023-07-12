package com.neu.edu.service.impl;

import com.neu.edu.mapper.WorkerMapper;
import com.neu.edu.service.WorkerService;
import com.neu.edu.mapper.GoodsMapper;
import com.neu.edu.service.GoodsService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.utils.ResultModelGetById;
import com.neu.edu.vo.GoodsVO;
import com.neu.edu.vo.WorkerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    WorkerMapper workerMapper;

    /**
     * getAllWorkersInfo
     * 获取所有员工信息
     */
    @Override
    public ResultModelGet<WorkerVO> getAllWorkersInfo(){
        ResultModelGet<WorkerVO> resultModelGet = new ResultModelGet<WorkerVO>();
        List<WorkerVO> worker = workerMapper.getAllWorkersInfo();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询员工成功!");
        resultModelGet.setData(worker);
        resultModelGet.setDataTotal(worker.size());
        return resultModelGet;
    }

    /**
     * getWorkersInfoByPage
     * 按页获取员工信息
     * @param page 页数
     * @param size 每页大小
     */
    @Override
    public ResultModelGet<WorkerVO> getWorkersInfoByPage(int page, int size){
        ResultModelGet<WorkerVO> resultModelGet = new ResultModelGet<>();
        resultModelGet = getAllWorkersInfo();
        // 按照每页大小划分员工数据，按页返回员工数据
        int dataTotal = resultModelGet.getDataTotal();
        int pageTotal = dataTotal / size;
        if (dataTotal % size != 0) {
            pageTotal += 1;
        }
        if (page > pageTotal) {
            resultModelGet.setStatus(1);
            resultModelGet.setMessage("参数错误(超出页数范围), 查询员工失败!");
            resultModelGet.setData(null);
        } else {
            resultModelGet.setStatus(0);
            resultModelGet.setMessage("查询员工成功!");
            resultModelGet.setDataTotal(pageTotal);
            resultModelGet.setData(resultModelGet.getData().subList((page - 1) * size, page * size));
        }
        return resultModelGet;
    }

    /**
     * addWorker
     * 添加员工
     * @param workerVO 员工信息
     */
    @Override
    public ResultModel addWorker(WorkerVO workerVO){
        ResultModel resultModel = new ResultModel();
        if (workerVO == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏数据！添加员工失败!");
        } else {
            // 判断员工是否已经存在
            WorkerVO worker = workerMapper.getWorkerInfoById(workerVO.getWorkerNum());
            if (worker != null) {
                resultModel.setStatus(1);
                resultModel.setMessage("员工已存在！添加员工失败!");
                return resultModel;
            }
            workerMapper.addWorker(workerVO);
            resultModel.setStatus(0);
            resultModel.setMessage("添加员工成功!");
        }
        return resultModel;
    }

    /**
     * deleteWorkerById
     * 按照id删除员工
     * @param id 员工id
     */
    @Override
    public ResultModel deleteWorkerById(int id){
        ResultModel resultModel = new ResultModel();
        // 判断员工是否存在
        WorkerVO worker = workerMapper.getWorkerInfoById(id);
        if (worker == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("员工不存在！删除员工失败!");
            return resultModel;
        }
        workerMapper.deleteWorkerById(id);
        resultModel.setStatus(0);
        resultModel.setMessage("删除员工成功!");
        return resultModel;
    }

    /**
     * updateWorker
     * 更新员工信息
     * @param workerVO 员工信息
     */
    @Override
    public ResultModel updateWorker(WorkerVO workerVO){
        ResultModel resultModel = new ResultModel();
        if (workerVO == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("缺乏数据！更新员工失败!");
        } else {
            // 判断员工是否存在
            WorkerVO worker = workerMapper.getWorkerInfoById(workerVO.getWorkerNum());
            if (worker == null) {
                resultModel.setStatus(1);
                resultModel.setMessage("员工不存在！更新员工失败!");
                return resultModel;
            }
            workerMapper.updateWorker(workerVO);
            resultModel.setStatus(0);
            resultModel.setMessage("更新员工成功!");
        }
        return resultModel;
    }

}
