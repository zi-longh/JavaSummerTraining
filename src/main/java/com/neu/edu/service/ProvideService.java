package com.neu.edu.service;

import com.neu.edu.utils.ResultModel;
import com.neu.edu.utils.ResultModelGet;
import com.neu.edu.vo.ProvideVO;

public interface ProvideService {
     ResultModelGet<ProvideVO> getAllProvidesInfo();
     ResultModelGet<ProvideVO> getProvidesInfoByPage(int page, int size);
     ResultModel addProvide(ProvideVO provideVO);
     ResultModel deleteProvideById(int provideNum);
     ResultModel updateProvide(ProvideVO provideVO);
}
