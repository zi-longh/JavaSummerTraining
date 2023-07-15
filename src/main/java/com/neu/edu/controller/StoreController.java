package com.neu.edu.controller;

import com.neu.edu.service.StoreService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.SaleVO;
import com.neu.edu.vo.StoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/store")
public class StoreController {
    @Autowired
    StoreService storeService;

    /**
     * 获取所有存储信息
     */
    @GetMapping(value = "/getAllStoresInfo")
    public ResultModelGet<StoreVO> getAllStoresInfo() {
        return storeService.getAllStoresInfo();
    }

    /**
     * 按页获取存储信息
     * @param page 页数
     * @param size 每页大小
     */
    @GetMapping(value = "/getStoresInfoByPage")
    public ResultModelGet<StoreVO> getStoresInfoByPage(int page, @RequestParam(value = "size", defaultValue = "2") int size) {
        return storeService.getStoresInfoByPage(page, size);
    }

    /**
     * 添加存储
     * @param storeVO 存储信息 不需要传入id, 会自动赋值
     */
    @PostMapping(value = "/addStore")
    public ResultModel addStore(@RequestBody StoreVO storeVO) {
        return storeService.addStore(storeVO);
    }

    /**
     * 删除存储
     * @param storeNum 存储编号
     */
    @DeleteMapping(value = "/deleteStoreById/{storeNum}")
    public ResultModel deleteStoreById(@PathVariable("storeNum") int storeNum) {
        return storeService.deleteStoreById(storeNum);
    }

    /**
     * 更新存储信息
     * @param storeVO 存储信息 必须传入id
     */
    @PutMapping(value = "/updateStore")
    public ResultModel updateStore(@RequestBody StoreVO storeVO) {
        return storeService.updateStore(storeVO);
    }


    /**
     * 更新存储信息，减少storageSum, 需要提供goo_goodsNum(商品编号), saleNum(销售数量)
     * @param saleVO 存储减少信息, 优先检索仓库202307
     */
    @PutMapping(value = "/updateStoreBySale")
    public ResultModel updateStoreBySale(@RequestBody SaleVO saleVO) {
        return storeService.updateStoreBySale(saleVO);
    }



}
