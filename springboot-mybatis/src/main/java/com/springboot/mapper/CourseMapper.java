package com.springboot.mapper;

import com.springboot.bean.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper {

    Course selectByCno(Integer cno);
}
