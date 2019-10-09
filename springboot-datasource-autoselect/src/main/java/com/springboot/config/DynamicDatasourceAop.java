package com.springboot.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用aop进行数据源的动态选择
 */
@Aspect
@Component
public class DynamicDatasourceAop {

    @Pointcut("execution(* com.springboot.controller.*.*(..))")
    public void pointCut() {
    }

    /**
     * 执行方法更换数据源
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String area = (String) request.getHeader("area");
        if (AreaKeyId.BEIJING.getArea().equals(area)) {
            DynamicDatasourceContextHolder.set(AreaKeyId.BEIJING);
        } else if (AreaKeyId.CHENGDU.getArea().equals(area)) {
            DynamicDatasourceContextHolder.set(AreaKeyId.CHENGDU);
        }
    }

    /**
     * 执行方法后清除数据源
     */
    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        //清除数据源
        DynamicDatasourceContextHolder.clear();
    }
}
