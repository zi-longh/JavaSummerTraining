package com.neu.edu.mapper;

import com.neu.edu.vo.GoodsVO;

import java.util.List;

public interface GoodsMapper {


    int deleteByPrimaryKey(Integer id);
    int insert(GoodsVO record);
    int insertSelective(GoodsVO record);
    GoodsVO selectByPrimaryKey(Integer id);
    List<GoodsVO> getAllGoodsInfo();
    int updateByPrimaryKeySelective(GoodsVO record);
    int updateByPrimaryKey(GoodsVO record);
}
