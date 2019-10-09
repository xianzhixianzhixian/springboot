package com.springboot.controller;

import com.springboot.bean.Course;
import com.springboot.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicDatasourceController {

    @Autowired
    private CourseMapper courseMapper;

    /**
     * 多数据源测试
     */
    @PostMapping("/insert")
    public Integer multiDataSource(@RequestBody Course course) {
        return courseMapper.insertCourse(course);
    }
}
