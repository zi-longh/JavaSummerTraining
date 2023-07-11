package com.neu.edu.controller;

import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// 等价于@Controller + @ResponseBody 依赖于jackson包
public class SubjectController {

    @Autowired
    @GetMapping(value = "/subjects")
    public ResultModel<List<SubjectVO>> getSubjects() {
        ResultModel<List<SubjectVO>> resultModel = new ResultModel<>();
        return resultModel;
    }
}
