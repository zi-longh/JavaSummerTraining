package com.neu.edu.mapper;

import com.neu.edu.vo.StorageVO;

import java.util.List;

public interface StorageMapper {
    /*
        getAllStoragesInfo
        getStorageInfoById
        addStorage
        addStorageWithoutId
        deleteStorageById
        updateStorage
    */
    List<StorageVO> getAllStoragesInfo();
    StorageVO getStorageInfoById(Integer storageNum);
    int addStorage(StorageVO storageVO);
    int addStorageWithoutId(StorageVO storageVO);
    int deleteStorageById(Integer storageNum);
    int updateStorage(StorageVO storageVO);


}
