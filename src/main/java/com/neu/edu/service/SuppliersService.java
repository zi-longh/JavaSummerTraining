package com.neu.edu.service;

import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.SupplierVO;

public interface SuppliersService {
    ResultModelGet<SupplierVO> getAllSuppliersInfo();
    ResultModelGet<SupplierVO> getSuppliersInfoByPage(int page, int size);
    ResultModel addSupplier(SupplierVO supplierVO);
    ResultModel deleteSupplierById(int id);
    ResultModel updateSupplier(SupplierVO supplierVO);

    ResultModelGet<String> getSupplierNum();
}
