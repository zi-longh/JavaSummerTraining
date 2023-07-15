package com.neu.edu.controller;

import com.neu.edu.service.CommonService;
import com.neu.edu.utils.JWTUtil;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.utils.ResultModelGetById;
import com.neu.edu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    /**
     * 需要提供参数goo_goodsNum, 查询可入库数量
     */
    @PostMapping(value = "/getAvailableNum")
    public ResultModelGetById<StoreInfoVO> getAvailableNum(@RequestBody StoreVO storeVO) {
        return commonService.getAvailableNum(storeVO);
    }

    /**
     * 清空购物车
     */
//    @PostMapping(value = "/sellGoods")
//    public ResultModel sellGoods(HttpServletRequest request, @RequestBody VO4 vo4) {
//        String token = request.getHeader("token");
//        return commonService.sellGoods(vo4.getSaleVOList(), vo4.getSaleTime(), JWTUtil.getUserInfoFromToken(token).getWorkerNum());
//    }

//    测试用
    @PostMapping(value = "/sellGoods")
    public ResultModel sellGoods(@RequestBody VO4 vo4) {
        return commonService.sellGoods(vo4.getSaleVOList(), vo4.getSaleTime(), 202201);
    }

}
