package com.neu.edu.controller;

import com.neu.edu.service.ProvideService;
import com.neu.edu.service.StorageService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.ProvideVO;
import com.neu.edu.vo.StorageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/provide")
public class ProvideController {

    @Autowired
    ProvideService provideService;

    /**
     * 获取所有供应商信息
     */
    @GetMapping(value = "/getAllProvidesInfo")
    public ResultModelGet<ProvideVO> getAllProvidesInfo() {
        return provideService.getAllProvidesInfo();
    }

    /**
     * 按页获取供应商信息
     * @param page 页数
     * @param size 每页大小
     */
    @GetMapping(value = "/getProvidesInfoByPage")
    public ResultModelGet<ProvideVO> getProvidesInfoByPage(int page, @RequestParam(value = "size", defaultValue = "2") int size) {
        return provideService.getProvidesInfoByPage(page, size);
    }

    /**
     * 添加供应商
     * @param provideVO 不需要传入id, 会自动赋值
     */
    @PostMapping(value = "/addProvide")
    public ResultModel addProvide(@RequestBody ProvideVO provideVO) {
        return provideService.addProvide(provideVO);
    }

    /**
     * 删除供应商
     * @param provideNum 供应商编号
     */
    @DeleteMapping(value = "/deleteProvideById/{provideNum}")
    public ResultModel deleteProvideById(@PathVariable("provideNum") int provideNum) {
        return provideService.deleteProvideById(provideNum);
    }

    /**
     * 更新供应商信息
     * @param provideVO 供应商信息 必须传入id
     */
    @PutMapping(value = "/updateProvide")
    public ResultModel updateProvide(@RequestBody ProvideVO provideVO) {
        return provideService.updateProvide(provideVO);
    }

}
