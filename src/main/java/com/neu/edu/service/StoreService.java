package com.neu.edu.service;

import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.StoreVO;

public interface StoreService {
    ResultModelGet<StoreVO> getAllStoresInfo();
    ResultModelGet<StoreVO> getStoresInfoByPage(int page, int size);
    ResultModel addStore(StoreVO storeVO);
    ResultModel deleteStoreById(int storeNum);
    ResultModel updateStore(StoreVO storeVO);
}
