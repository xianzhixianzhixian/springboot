package com.springboot.config;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 利用aop收集web请求的日志
 */
@Aspect
@Component
public class WebLoggerConfig {

    private static final Logger logger = LoggerFactory.getLogger(WebLoggerConfig.class);

    @Pointcut("execution(* com.springboot.controller.*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURL = request.getRequestURL().toString();
        String requestURI = request.getRequestURI().toString();
        String method = request.getMethod();
        String ipAddress = request.getRemoteAddr();
        Enumeration<String> attributeNames = request.getAttributeNames();
        String attributesNamesStr = JSON.toJSONString(attributeNames);
        logger.info("URL: {}, URI: {}, method: {}, IP: {}, attributesNames: {}", requestURL, requestURI, method, ipAddress, attributesNamesStr);
    }

    @After("pointCut()")
    public void doAfter() {
    }
}
