package com.springboot.mapper;

import com.springboot.bean.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CourseMapper {

    @Select("select * from course where cno = #{cno}")
    public Course selectByCno(@Param("cno") Integer cno);
}
