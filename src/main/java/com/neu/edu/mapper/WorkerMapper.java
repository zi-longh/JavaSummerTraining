package com.neu.edu.mapper;

import com.neu.edu.vo.WorkerVO;

import java.util.List;

public interface WorkerMapper {
    /*
        getAllWorkerInfo
        getWorkerInfoById
        addWorker
        deleteWorkerById
        updateWorker
     */
    List<WorkerVO> getAllWorkersInfo();
    WorkerVO getWorkerInfoById(Integer workerNum);
    WorkerVO getWorkerInfoByName(String name);
    List<String> getWorkerNum();
    int addWorker(WorkerVO workerVO);
    int addWorkerWithoutId(WorkerVO workerVO);
    int deleteWorkerById(Integer workerNum);
    int updateWorker(WorkerVO workerVO);
}
