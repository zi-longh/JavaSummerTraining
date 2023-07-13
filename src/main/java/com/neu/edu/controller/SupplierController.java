package com.neu.edu.controller;

import com.neu.edu.service.SuppliersService;
import com.neu.edu.vo.SupplierVO;
import org.springframework.web.bind.annotation.RestController;
import com.neu.edu.service.StoreService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.StoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierController {
    @Autowired
    SuppliersService suppliersService;

    /**
     * 获取所有供应商信息
     */
    @GetMapping(value = "/supplier/getAllSuppliersInfo")
    public ResultModelGet<SupplierVO> getAllSuppliersInfo() {
        return suppliersService.getAllSuppliersInfo();
    }

    /**
     * 按页获取供应商信息
     * @param page 页数
     * @param size 每页大小
     */
    @GetMapping(value = "/supplier/getSuppliersInfoByPage")
    public ResultModelGet<SupplierVO> getSuppliersInfoByPage(int page, @RequestParam(value = "size", defaultValue = "2") int size) {
        return suppliersService.getSuppliersInfoByPage(page, size);
    }

    /**
     * 添加供应商
     * @param supplierVO 供应商信息 不需要传入id(supplierNum), 会自动赋值
     */
    @PostMapping(value = "/supplier/addSupplier")
    public ResultModel addSupplier(SupplierVO supplierVO) {
        return suppliersService.addSupplier(supplierVO);
    }

    /**
     * 删除供应商
     * @param supplierNum 供应商编号
     */
    @PostMapping(value = "/supplier/deleteSupplierById/{supplierNum}")
    public ResultModel deleteSupplierById(@PathVariable("supplierNum") int supplierNum) {
        return suppliersService.deleteSupplierById(supplierNum);
    }

    /**
     * 更新供应商信息
     * @param supplierVO 供应商信息 必须传入id(supplierNum)
     */
    @PutMapping(value = "/supplier/updateSupplier")
    public ResultModel updateSupplier(SupplierVO supplierVO) {
        return suppliersService.updateSupplier(supplierVO);
    }


}
