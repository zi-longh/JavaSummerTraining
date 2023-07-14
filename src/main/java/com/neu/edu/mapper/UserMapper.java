package com.neu.edu.mapper;

import com.neu.edu.vo.GoodsVO;
import com.neu.edu.vo.UserVO;

import java.util.List;

public interface UserMapper {
    /*
        login
        getUserInfoById
    */
    UserVO login(String userName);
    UserVO getUserInfoById(String userName);
    int register(UserVO userVO);
    int updateUser(UserVO userVO);
    int deleteUserById(String username);
}
