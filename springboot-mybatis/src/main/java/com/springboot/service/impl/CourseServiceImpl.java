package com.springboot.service.impl;

import com.springboot.bean.Course;
import com.springboot.mapper.library.LibraryMapper;
import com.springboot.mapper.course.CourseMapper;
import com.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public Integer addCourse(Course course) {
        courseMapper.insertCourse(course);
        libraryMapper.insertCourse(course);
        return 2;
    }
}
