package com.neu.edu.interceptor;

import com.neu.edu.utils.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//         获取token
        String token = request.getHeader("token");
        System.out.println(token);
        // 验证token
        return JWTUtil.verifyToken(token);
//        return true;
    }
}
