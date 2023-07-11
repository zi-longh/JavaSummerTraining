package com.neu.edu.service.impl;

import com.neu.edu.mapper.SubjectMapper;
import com.neu.edu.service.SubjectService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectMapper subjectMapper;
    @Override
    public ResultModel<List<SubjectVO>> findAll() {
        ResultModel<List<SubjectVO>> resultModel = new ResultModel<List<SubjectVO>>();
        List<SubjectVO> subjectVOList = subjectMapper.findAll();

        resultModel.setCode(200);
        resultModel.setMsg("查询学科成功");
        resultModel.setData(subjectVOList);
        return resultModel;
    }


}
