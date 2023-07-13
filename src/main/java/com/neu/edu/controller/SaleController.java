package com.neu.edu.controller;

import com.neu.edu.service.SaleService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.SaleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {
    @Autowired
    SaleService saleService;

    /**
     * 获取所有销售信息
     */
    @GetMapping(value = "/getAllSalesInfo")
    public ResultModelGet<SaleVO> getAllSalesInfo() {
        return saleService.getAllSalesInfo();
    }

    /**
     * 按页获取销售信息
     * @param page 页数
     * @param size 每页大小
     */
    @GetMapping(value = "/getSalesInfoByPage")
    public ResultModelGet<SaleVO> getSalesInfoByPage(int page, @RequestParam(value = "size", defaultValue = "2") int size) {
        return saleService.getSalesInfoByPage(page, size);
    }

    /**
     * 添加销售
     * @param saleVO 销售信息 可以不传入saleNum，saleNum为null会自动赋值
     */
    @PostMapping(value = "/addSale")
    public ResultModel addSale(@RequestBody SaleVO saleVO) {
        return saleService.addSale(saleVO);
    }

    /**
     * 删除销售
     * @param saleNum 销售编号
     */
    @DeleteMapping(value = "/deleteSaleById/{saleNum}")
    public ResultModel deleteSaleById(@PathVariable("saleNum") int saleNum) {
        return saleService.deleteSaleById(saleNum);
    }

    /**
     * 更新销售信息
     * @param saleVO 销售信息 必须传入saleNum
     */
    @PutMapping(value = "/updateSale")
    public ResultModel updateSale(@RequestBody SaleVO saleVO) {
        return saleService.updateSale(saleVO);
    }



}
