package com.neu.edu.controller;

import com.neu.edu.service.WorkerService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.WorkerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/worker")
public class WorkerController {
    @Autowired
    WorkerService workerService;

    /**
     * 获取所有员工信息
     */
    @GetMapping(value = "/getAllWorkersInfo")
    public ResultModelGet<WorkerVO> getAllWorkerInfo() {
        return workerService.getAllWorkersInfo();
    }

    /**
     * 按页获取员工信息
     * @param page 页数
     * @param size 每页大小
     */
    @GetMapping(value = "/getWorkersInfoByPage")
    public ResultModelGet<WorkerVO> getWorkersInfoByPage(int page, @RequestParam(value = "size", required = true) int size) {
        return workerService.getWorkersInfoByPage(page, size);
    }

    /**
     * 获取员工编号
     */
    @GetMapping(value = "/getWorkersNum")
    public ResultModelGet<String> getWorkerNum() {
        return workerService.getWorkerNum();
    }

    /**
     * 添加员工
     * @param workerVO 员工信息 可以不传入workerNum
     */
    @PostMapping(value = "/addWorker")
    public ResultModel addWorker(@RequestBody WorkerVO workerVO) {
        return workerService.addWorker(workerVO);
    }

    /**
     * 删除员工
     * @param workerNum 员工编号
     */
    @DeleteMapping(value = "/deleteWorkerById/{workerNum}")
    public ResultModel deleteWorkerById(@PathVariable("workerNum") int workerNum) {
        return workerService.deleteWorkerById(workerNum);
    }

    /**
     * 更新员工信息
     * @param workerVO 员工信息
     */
    @PutMapping(value = "/updateWorker")
    public ResultModel updateWorker(@RequestBody WorkerVO workerVO) {
        return workerService.updateWorker(workerVO);
    }

}
