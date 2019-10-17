package com.springboot.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 * @ContrllerAdvice 可以这么理解，其抽象级别应该是用于对Controller进行“切面”环绕的，而具体的业务织入方式则是通过结合其他的注解来实现的
 * @ControllerAdvice 是在类上声明的注解，其用法主要有三点：
 * 结合方法型注解@ExceptionHandler，用于捕获Controller中抛出的指定类型的异常，从而达到不同类型的异常区别处理的目的；
 * 结合方法型注解@InitBinder，用于request中自定义参数解析方式进行注册，从而达到自定义指定格式参数的目的；
 * 结合方法型注解@ModelAttribute，表示其标注的方法将会在目标Controller方法执行之前执行
 * 可以结合@Sl4j实现日志打印
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @ExceptionHandler 可以拦截特定类型的Exception，只需在括号中写入异常的类型
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, String> runtimeExceptionHandler() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("returnCode", "500");
        resultMap.put("message", "运行时异常");
        return resultMap;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Map<String, String> nullPointExceptionHandler() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("returnCode", "500");
        resultMap.put("message", "空指针异常");
        return resultMap;
    }
}
