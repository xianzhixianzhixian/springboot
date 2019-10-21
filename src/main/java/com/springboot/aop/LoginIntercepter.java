package com.springboot.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
@Component
public class LoginIntercepter implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginIntercepter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("拦截器开始");
        String token = request.getHeader("token");
        logger.info("获得的token值{}", token);
        if (token == null || token.length() == 0) {
            response.getWriter().println("no token exist");
            return false;
        }
        return true;
//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}
