package com.neu.edu.service;

import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.SaleVO;

public interface SaleService {
    ResultModelGet<SaleVO> getAllSalesInfo();
    ResultModelGet<SaleVO> getSalesInfoByPage(int page, int size);
    ResultModel addSale(SaleVO saleVO);
    ResultModel deleteSaleById(int saleNum);
    ResultModel updateSale(SaleVO saleVO);
}
