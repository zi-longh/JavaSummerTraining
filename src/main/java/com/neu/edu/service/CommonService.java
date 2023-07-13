package com.neu.edu.service;

import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.VO1;
import com.neu.edu.vo.VO2;
import com.neu.edu.vo.VO3;

public interface CommonService {
    public ResultModelGet<VO1> getInfo1();
    public ResultModelGet<VO2> getInfo2();
    public ResultModelGet<VO3> getInfo3();
}
