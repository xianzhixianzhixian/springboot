package com.springboot.service.impl;

import com.springboot.bean.Course;
import com.springboot.mapper.library.LibraryMapper;
import com.springboot.mapper.course.CourseMapper;
import com.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public Integer addCourse(Course course) {
        courseMapper.insertCourse(course);
        //为了测试事务,在这里course数据库里的数据能够插入成功,library数据库里的数据不能插入成功
        //int result = 1/0;
        libraryMapper.insertCourse(course);
        //为了测试事务,在这里course、library数据库里的数据都能够插入成功
        //int result = 1/0;
        return 2;
    }

    @Override
    @Transactional
    public Integer addDividedCourse(Course course) {
        courseMapper.insertCourse(course);
        int result = 1/0;
        libraryMapper.insertCourse(course);
        return 0;
    }
}
