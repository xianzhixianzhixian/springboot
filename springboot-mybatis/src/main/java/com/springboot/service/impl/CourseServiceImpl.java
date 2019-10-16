package com.springboot.service.impl;

import com.springboot.bean.Course;
import com.springboot.mapper.library.LibraryMapper;
import com.springboot.mapper.course.CourseMapper;
import com.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private LibraryMapper libraryMapper;
    //CacheManager可以操作EhCache缓存中的内容
    @Autowired
    private CacheManager cacheManager;

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

    @Override
    public Integer updateByPrimaryKey(Course course) {
        //这里的oldCourse是从缓存中取出来的数据，所以直接更改后再更新的话，缓存中的数据是会变化的
        //如果不从缓存中取数据直接更新，更改之后缓存中的数据不一定会被更新
        //List<Course> oldCourse = courseMapper.selectByCno(course.getCno());
        //course = oldCourse.get(0);
        //清除缓存
        cacheManager.getCache("baseCache").clear();
        return courseMapper.updateByPrimaryKey(course);
    }
}
