package com.springboot.controller;

import com.springboot.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private SchoolService schoolService;

    @GetMapping(value = "/hello")
    public String hello() {
        logger.info("hello info {}", "infoLogger");
        logger.error("hello error {}", "errorLogger");
        return "Hello world";
    }

    @PostMapping("/async")
    public String ascyn() {
        schoolService.async();
        return "async()开始执行";
    }
}
