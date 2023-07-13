package com.neu.edu.service.impl;

import com.neu.edu.mapper.CommonMapper;
import com.neu.edu.service.CommonService;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.VO1;
import com.neu.edu.vo.VO2;
import com.neu.edu.vo.VO3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    CommonMapper commonMapper;

    @Override
    public ResultModelGet<VO1> getInfo1(){
        ResultModelGet<VO1> resultModelGet = new ResultModelGet<VO1>();
        List<VO1> vo1 = commonMapper.getInfo1();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询成功!");
        resultModelGet.setData(vo1);
        return resultModelGet;
    }

    @Override
    public ResultModelGet<VO2> getInfo2(){
        ResultModelGet<VO2> resultModelGet = new ResultModelGet<VO2>();
        List<VO2> vo2 = commonMapper.getInfo2();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询成功!");
        resultModelGet.setData(vo2);
        return resultModelGet;
    }

    @Override
    public ResultModelGet<VO3> getInfo3(){
        ResultModelGet<VO3> resultModelGet = new ResultModelGet<VO3>();
        List<VO3> vo3 = commonMapper.getInfo3();
        resultModelGet.setStatus(0);
        resultModelGet.setMessage("查询成功!");
        resultModelGet.setData(vo3);
        return resultModelGet;
    }


}
