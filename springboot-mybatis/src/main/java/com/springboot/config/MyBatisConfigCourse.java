package com.springboot.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 *
 */
@Configuration
@MapperScan(basePackages = "com.springboot.mapper.course", sqlSessionFactoryRef = "courseSqlSessionTemplate")
public class MyBatisConfigCourse {

    @Primary
    @Bean(name = "courseDataSource")
    public DataSource courseDataSource(DbConfigCourse dbConfigCourse) throws Exception {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL(dbConfigCourse.getUrl());
        mysqlXADataSource.setUser(dbConfigCourse.getUsername());
        mysqlXADataSource.setPassword(dbConfigCourse.getPassword());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("courseDataSource");
        return mysqlXADataSource;
    }

    @Primary
    @Bean(name = "courseSqlSessionFactory")
    public SqlSessionFactory courseSqlSessionFactory(@Qualifier("courseDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "courseSqlSessionTemplate")
    public SqlSessionTemplate courseSqlSessionTemplate(@Qualifier("courseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
