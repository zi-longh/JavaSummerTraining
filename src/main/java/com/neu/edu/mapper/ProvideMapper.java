package com.neu.edu.mapper;

import com.neu.edu.vo.ProvideVO;

import java.util.List;

public interface ProvideMapper {
    /*
        getAllProvidesInfo
        getProvideInfoById
        addProvide
        deleteProvideById
        updateProvide
     */
    List<ProvideVO> getAllProvidesInfo();
    ProvideVO getProvideInfoById(Integer provideNum);
    int addProvide(ProvideVO provideVO);
    int deleteProvideById(Integer provideNum);
    int updateProvide(ProvideVO provideVO);
}
