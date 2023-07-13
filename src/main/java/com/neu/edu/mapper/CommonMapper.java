package com.neu.edu.mapper;

import com.neu.edu.vo.VO1;
import com.neu.edu.vo.VO2;
import com.neu.edu.vo.VO3;

import java.util.List;

public interface CommonMapper {
    List<VO1> getInfo1();
    List<VO2> getInfo2();
    List<VO3> getInfo3();
}
