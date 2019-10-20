package com.springboot.service.impl;

import com.springboot.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service 要放在实现类上而不是接口上
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    private Logger logger = LoggerFactory.getLogger(SchoolServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List getCourse() {
        try {
            List list = jdbcTemplate.queryForList("select * from course");
            logger.info("查出来的数据" + list.toString());
            return list;
        } catch (Exception e) {
            logger.error("查询数据出错", e);
            return null;
        }

    }

    @Scheduled(cron = "0/2 * * * * ?")
    @Override
    public void cron() {
        logger.info("定时任务，当前时间{}", System.currentTimeMillis());
    }

    @Async
    @Override
    public void async() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
                logger.info("异步任务计数器，当前数值{}", i);
            } catch (Exception e) {
                logger.error("异步任务发生错误，原因{}", e.getMessage());
            }
        }
    }
}
