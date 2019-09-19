package com.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.bean.Course;
import com.springboot.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping("/course")
    public List<Course> getCourse(Integer cno) {
        return courseMapper.selectByCno(cno);
    }

    @GetMapping("/pagecourse")
    public PageInfo<Course> getCourseByPage(Integer cno, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Course> courses = courseMapper.selectByCno(cno);
        PageInfo<Course> pageInfo = new PageInfo<>(courses);
        return pageInfo;
    }
}
