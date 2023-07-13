package com.neu.edu.service;

import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.StorageVO;
import com.neu.edu.vo.VO2;

public interface StorageService {
    ResultModelGet<StorageVO> getAllStoragesInfo();
    ResultModelGet<StorageVO> getStoragesInfoByPage(int page, int size);
    ResultModel addStorage(StorageVO storageVO);
    ResultModel deleteStorageById(int storageNum);
    ResultModel updateStorage(StorageVO storageVO);

    ResultModelGet<String> getStoragesNum();
}
