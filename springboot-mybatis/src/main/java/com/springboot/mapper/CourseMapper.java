package com.springboot.mapper;

import com.springboot.bean.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    List<Course> selectByCno(Integer cno);
}
