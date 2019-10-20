package com.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制热部署的controller
 */
@RestController
public class RestartController {

    @Value("${name}")
    private String name;

    @PostMapping("/name")
    public String name() {
        return name;
    }
}
