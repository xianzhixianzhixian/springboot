package com.springboot.controller;

import com.springboot.bean.Course;
import com.springboot.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping("/course")
    public Course getCourse(Integer cno) {
        return courseMapper.selectByCno(cno);
    }
}
