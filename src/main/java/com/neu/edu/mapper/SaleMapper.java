package com.neu.edu.mapper;

import com.neu.edu.vo.SaleVO;
import com.neu.edu.vo.VO3;

import java.util.List;

public interface SaleMapper {
    /*
        getAllSalesInfo
        getSaleInfoById
        addSale
        addSaleWithoutId
        deleteSaleById
        updateSale
        getSaleNum
    */
    List<SaleVO> getAllSalesInfo();
    SaleVO getSaleInfoById(Integer saleNum);
    int addSale(SaleVO saleVO);
    int addSaleWithoutId(SaleVO saleVO);
    int deleteSaleById(Integer saleNum);
    int updateSale(SaleVO saleVO);

}
