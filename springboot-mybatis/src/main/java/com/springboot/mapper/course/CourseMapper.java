package com.springboot.mapper.course;

import com.springboot.bean.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
@CacheConfig(cacheNames = "baseCache")
public interface CourseMapper {

    @Cacheable
    List<Course> selectByCno(Long cno);

    Integer insertCourse(Course course);
}
