package com.springboot.service;

import java.util.List;

public interface SchoolService {

    /**
     * 查询课程
     * @return
     */
    List getCourse();

    /**
     * 定时任务
     */
    void cron();

    /**
     * 异步任务
     */
    void async();
}
