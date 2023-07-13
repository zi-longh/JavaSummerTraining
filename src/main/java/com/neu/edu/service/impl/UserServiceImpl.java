package com.neu.edu.service.impl;

import com.neu.edu.mapper.UserMapper;
import com.neu.edu.service.UserService;
import com.neu.edu.utils.ResultModelGetById;
import com.neu.edu.vo.UserVO;
import org.springframework.stereotype.Service;
import com.neu.edu.mapper.SupplierMapper;
import com.neu.edu.service.SuppliersService;
import com.neu.edu.mapper.StoreMapper;
import com.neu.edu.service.StoreService;
import com.neu.edu.vo.StoreVO;
import com.neu.edu.vo.SupplierVO;
import org.springframework.stereotype.Service;
import com.neu.edu.mapper.SaleMapper;
import com.neu.edu.service.SaleService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.SaleVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 登录
     * @param userName 用户名
     * @param password 密码
     */
    @Override
    public ResultModelGetById<UserVO> login(String userName, String password) {
        ResultModelGetById<UserVO> resultModelGetById = new ResultModelGetById<>();
        if (userName == null || password == null) {
            resultModelGetById.setStatus(1);
            resultModelGetById.setMessage("用户名或密码为空!");
            resultModelGetById.setData(null);
        } else {
            UserVO userVO = userMapper.login(userName);
            if (userVO == null) {
                resultModelGetById.setStatus(1);
                resultModelGetById.setMessage("用户名不存在!");
                resultModelGetById.setData(null);
            } else if (!userVO.getPassword().equals(password)) {
                resultModelGetById.setStatus(1);
                resultModelGetById.setMessage("密码错误!");
                resultModelGetById.setData(null);
            } else {
                resultModelGetById.setStatus(0);
                resultModelGetById.setMessage("登录成功!");
                resultModelGetById.setData(userVO);
            }
        }
        return resultModelGetById;
    }

    /**
     * 按id查询用户
     * @param userName 用户id(name)
     */
    @Override
    public ResultModelGetById<UserVO> getUserInfoById(String userName) {
        ResultModelGetById<UserVO> resultModelGetById = new ResultModelGetById<>();
        UserVO userVO = userMapper.getUserInfoById(userName);
        if (userVO == null) {
            resultModelGetById.setStatus(1);
            resultModelGetById.setMessage("用户不存在!");
            resultModelGetById.setData(null);
        } else {
            resultModelGetById.setStatus(0);
            resultModelGetById.setMessage("查询用户成功!");
            resultModelGetById.setData(userVO);
        }
        return resultModelGetById;
    }

    /**
     * 注册用户
     * @param userVO 用户信息
     */
    @Override
    public ResultModel register(UserVO userVO) {
        ResultModel resultModel = new ResultModel();
        if (userVO.getUserName() == null || userVO.getPassword() == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("用户名或密码为空!");
        } else {
            UserVO userVO1 = userMapper.getUserInfoById(userVO.getUserName());
            if (userVO1 != null) {
                resultModel.setStatus(1);
                resultModel.setMessage("用户名已存在!");
            } else {
                userMapper.register(userVO);
                resultModel.setStatus(0);
                resultModel.setMessage("注册成功!");
            }
        }
        return resultModel;
    }
    /**
     * 删除用户
     * @param userName 用户名
     */

    @Override
    public ResultModel deleteUserById(String userName) {
        ResultModel resultModel = new ResultModel();
        if (userName == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("用户名为空!");
        } else {
            UserVO userVO = userMapper.getUserInfoById(userName);
            if (userVO == null) {
                resultModel.setStatus(1);
                resultModel.setMessage("用户不存在!");
            } else {
                userMapper.deleteUserById(userName);
                resultModel.setStatus(0);
                resultModel.setMessage("删除用户成功!");
            }
        }
        return resultModel;
    }

    /**
     * 更新用户信息
     * @param userVO 用户信息
     */
    @Override
    public ResultModel updateUser(UserVO userVO) {
        ResultModel resultModel = new ResultModel();
        if (userVO.getUserName() == null || userVO.getPassword() == null) {
            resultModel.setStatus(1);
            resultModel.setMessage("用户名或密码为空!");
        } else {
            UserVO userVO1 = userMapper.getUserInfoById(userVO.getUserName());
            if (userVO1 == null) {
                resultModel.setStatus(1);
                resultModel.setMessage("用户不存在!");
            } else {
                userMapper.updateUser(userVO);
                resultModel.setStatus(0);
                resultModel.setMessage("更新用户信息成功!");
            }
        }
        return resultModel;
    }




}
