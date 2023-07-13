package com.neu.edu.controller;

import com.neu.edu.service.CommonService;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.VO1;
import com.neu.edu.vo.VO2;
import com.neu.edu.vo.VO3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/data")
public class CommonController {
    @Autowired
    CommonService commonService;

    @GetMapping(value = "/getInfo1")
    public ResultModelGet<VO1> getInfo1() {
        return commonService.getInfo1();
    }

    @GetMapping(value = "/getInfo2")
    public ResultModelGet<VO2> getInfo2() {
        return commonService.getInfo2();
    }

    @GetMapping(value = "/getInfo3")
    public ResultModelGet<VO3> getInfo3() {
        return commonService.getInfo3();
    }

}
