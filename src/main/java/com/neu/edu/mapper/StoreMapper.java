package com.neu.edu.mapper;

import com.neu.edu.vo.StoreVO;

import java.util.List;

public interface StoreMapper {

    /*
        getAllStoresInfo
        getStoreInfoById
        addStore
        deleteStoreById
        updateStore
     */
    List<StoreVO> getAllStoresInfo();
    StoreVO getStoreInfoById(Integer storeNum);
    int addStore(StoreVO storeVO);
    int deleteStoreById(Integer storeNum);
    int updateStore(StoreVO storeVO);

}
