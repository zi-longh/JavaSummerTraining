package com.neu.edu.mapper;

import com.neu.edu.vo.SupplierVO;

import java.util.List;

public interface SuppliersMapper {
    /*
        getAllSuppliersInfo
        getSupplierInfoById
        addSupplier
        deleteSupplierById
        updateSupplier
    */
    List<SupplierVO> getAllSuppliersInfo();
    SupplierVO getSupplierInfoById(Integer supplierNum);
    int addSupplier(SupplierVO supplierVO);
    int deleteSupplierById(Integer supplierNum);
    int updateSupplier(SupplierVO supplierVO);
    
}
