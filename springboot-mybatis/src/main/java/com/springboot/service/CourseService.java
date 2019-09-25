package com.springboot.service;

import com.springboot.bean.Course;

public interface CourseService {

    /**
     * 插入书籍
     * @param course
     * @return
     */
    Integer addCourse(Course course);
}
