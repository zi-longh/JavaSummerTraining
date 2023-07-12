package com.neu.edu.mapper;

import com.neu.edu.vo.WorkerVO;

import java.util.List;

public interface WorkerMapper {
    /*
        getAllWorkerInfo
        addWorker
        deleteWorkerById
        updateWorker
     */
    List<WorkerVO> getAllWorkersInfo();
    WorkerVO getWorkerInfoById(Integer workerNum);
    int addWorker(WorkerVO workerVO);
    int deleteWorkerById(Integer workerNum);
    int updateWorker(WorkerVO workerVO);
}
