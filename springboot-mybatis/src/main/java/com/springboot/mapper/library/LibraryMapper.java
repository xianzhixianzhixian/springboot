package com.springboot.mapper.library;

import com.springboot.bean.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LibraryMapper {

    List<Course> selectByCno(Long cno);

    Integer insertCourse(Course course);
}
