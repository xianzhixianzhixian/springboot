package com.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.bean.Course;
import com.springboot.mapper.course.CourseMapper;
import com.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DatasourceController {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public List<Course> getCourse(Long cno) {
        return courseMapper.selectByCno(cno);
    }

    @GetMapping("/pagecourse")
    public PageInfo<Course> getCourseByPage(@RequestBody Long cno, @RequestBody Integer pageNum, @RequestBody Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Course> courses = courseMapper.selectByCno(cno);
        PageInfo<Course> pageInfo = new PageInfo<>(courses);
        return pageInfo;
    }

    /**
     * 多数据源测试
     */
    @PostMapping("/insert")
    public Integer multiDataSource(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    /**
     * 根据课程号获取课程数据
     * @param cno
     * @return
     */
    @GetMapping("/getCache")
    public List getCache(Long cno) {
        return courseMapper.selectByCno(cno);
    }

    @PostMapping("/updateByPrimaryKey")
    public Integer updateByPrimaryKey(@RequestBody Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }
}
