package com.neu.edu.mapper;

import com.neu.edu.vo.*;

import java.util.List;

public interface CommonMapper {
    List<VO1> getInfo1();
    List<VO2> getInfo2();
    List<VO3> getInfo3();

    StoreInfoVO getAvailableNum(StoreVO storeVO);
}
