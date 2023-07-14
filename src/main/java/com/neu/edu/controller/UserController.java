package com.neu.edu.controller;

import com.neu.edu.service.SuppliersService;
import com.neu.edu.service.UserService;
import com.neu.edu.utils.ResultModelGetById;
import com.neu.edu.vo.SupplierVO;
import com.neu.edu.vo.UserVO;
import org.springframework.web.bind.annotation.RestController;
import com.neu.edu.service.StoreService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.StoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 登录
     * @param userVO 用户信息 必须传入用户名和密码
     */
    @PostMapping(value = "/login")
    public ResultModelGetById<String> login(UserVO userVO) {
        return userService.login(userVO.getUserName(), userVO.getPassword());
    }

    /**
     * 获取用户信息
     * @param userName 用户名
     */
    @GetMapping(value = "/getUserInfoById/{userName}")
    public ResultModelGetById<UserVO> getUserInfoById(@PathVariable("userName") String userName) {
        return userService.getUserInfoById(userName);
    }

    /**
     * 注册
     * @param userVO 用户信息 必须传入用户名和密码
     */
    @PostMapping(value = "/register")
    public ResultModel register(@RequestBody UserVO userVO) {
        return userService.register(userVO);
    }

    /**
     * 更新用户信息
     * @param userVO 用户信息 必须传入用户名
     */
    @PutMapping(value = "/updateUser")
    public ResultModel updateUser(@RequestBody UserVO userVO) {
        return userService.updateUser(userVO);
    }

    /**
     * 删除用户
     * @param userName 用户名
     */
    @DeleteMapping(value = "/deleteUserById/{userName}")
    public ResultModel deleteUserById(@PathVariable("userName") String userName) {
        return userService.deleteUserById(userName);
    }


}
