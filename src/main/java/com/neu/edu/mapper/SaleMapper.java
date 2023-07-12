package com.neu.edu.mapper;

import com.neu.edu.vo.SaleVO;

import java.util.List;

public interface SaleMapper {
    /*
        getAllSalesInfo
        getSaleInfoById
        addSale
        addSaleWithoutId
        deleteSaleById
        updateSale
    */
    List<SaleVO> getAllSalesInfo();
    SaleVO getSaleInfoById(Integer saleNum);
    int addSale(SaleVO saleVO);
    int addSaleWithoutId(SaleVO saleVO);
    int deleteSaleById(Integer saleNum);
    int updateSale(SaleVO saleVO);
}
