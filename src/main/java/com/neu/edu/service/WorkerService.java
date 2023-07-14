package com.neu.edu.service;

import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.WorkerVO;

public interface WorkerService {
    ResultModelGet<WorkerVO> getAllWorkersInfo();
    ResultModelGet<WorkerVO> getWorkersInfoByPage(int page, int size);
    ResultModel addWorker(WorkerVO workerVO);
    ResultModel deleteWorkerById(int id);
    ResultModel updateWorker(WorkerVO workerVO);

    ResultModelGet<String> getWorkerNum();
}
