package com.springboot.mapper.course;

import com.springboot.bean.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    List<Course> selectByCno(Long cno);

    Integer insertCourse(Course course);
}
