package com.neu.edu.service;

import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.utils.ResultModelGetById;
import com.neu.edu.vo.*;

public interface CommonService {
    public ResultModelGet<VO1> getInfo1();
    public ResultModelGet<VO2> getInfo2();
    public ResultModelGet<VO3> getInfo3();
    public ResultModelGetById<StoreInfoVO> getAvailableNum(StoreVO storeVO);
}
