package com.neu.edu.service;

import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.utils.ResultModelGetById;
import com.neu.edu.vo.UserVO;

public interface UserService {
    ResultModelGetById<UserVO> login(String userName, String password);
    ResultModelGetById<UserVO> getUserInfoById(String userName);
    ResultModel register(UserVO userVO);
    ResultModel updateUser(UserVO userVO);
    ResultModel deleteUserById(String username);
}
