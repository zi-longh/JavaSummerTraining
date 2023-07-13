package com.neu.edu.controller;

import com.neu.edu.service.StoreService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.StoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {
    @Autowired
    StoreService storeService;

    /**
     * 获取所有存储信息
     */
    @GetMapping(value = "/store/getAllStoresInfo")
    public ResultModelGet<StoreVO> getAllStoresInfo() {
        return storeService.getAllStoresInfo();
    }

    /**
     * 按页获取存储信息
     * @param page 页数
     * @param size 每页大小
     */
    @GetMapping(value = "/store/getStoresInfoByPage")
    public ResultModelGet<StoreVO> getStoresInfoByPage(int page, @RequestParam(value = "size", defaultValue = "2") int size) {
        return storeService.getStoresInfoByPage(page, size);
    }

    /**
     * 添加存储
     * @param storeVO 存储信息 不需要传入id, 会自动赋值
     */
    @PostMapping(value = "/store/addStore")
    public ResultModel addStore(StoreVO storeVO) {
        return storeService.addStore(storeVO);
    }

    /**
     * 删除存储
     * @param storeNum 存储编号
     */
    @PostMapping(value = "/store/deleteStoreById/{storeNum}")
    public ResultModel deleteStoreById(@PathVariable("storeNum") int storeNum) {
        return storeService.deleteStoreById(storeNum);
    }

    /**
     * 更新存储信息
     * @param storeVO 存储信息 必须传入id
     */
    @PutMapping(value = "/store/updateStore")
    public ResultModel updateStore(StoreVO storeVO) {
        return storeService.updateStore(storeVO);
    }


}
