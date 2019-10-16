package com.springboot.service;

import com.springboot.bean.Course;
import org.springframework.transaction.annotation.Transactional;

public interface CourseService {

    /**
     * 插入书籍
     * @param course
     * @return
     */
    Integer addCourse(Course course);

    /**
     * 分布式事务添加书籍
     * @param course
     * @return
     */
    Integer addDividedCourse(Course course);

    /**
     * 根据主键更新数据
     * @param course
     * @return
     */
    Integer updateByPrimaryKey(Course course);
}
