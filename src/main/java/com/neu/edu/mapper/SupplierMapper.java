package com.neu.edu.mapper;

import com.neu.edu.vo.SupplierVO;

import java.util.List;

public interface SupplierMapper {
    /*
        getAllSuppliersInfo
        getSupplierInfoById
        getSupplierInfoByName
        addSupplier
        deleteSupplierById
        updateSupplier
    */
    List<SupplierVO> getAllSuppliersInfo();
    SupplierVO getSupplierInfoById(Integer supplierNum);
    SupplierVO getSupplierInfoByName(String supplierName);
    int addSupplier(SupplierVO supplierVO);
    int deleteSupplierById(Integer supplierNum);
    int updateSupplier(SupplierVO supplierVO);

}
