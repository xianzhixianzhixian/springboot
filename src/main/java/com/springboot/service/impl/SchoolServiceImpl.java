package com.springboot.service.impl;

import com.springboot.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
}
