package com.springboot.controller;

import com.springboot.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JdbcController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/course")
    public List course() {
        return schoolService.getCourse();
    }
}
