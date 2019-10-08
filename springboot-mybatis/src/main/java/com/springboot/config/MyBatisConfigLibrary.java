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
@MapperScan(basePackages = "com.springboot.mapper.library", sqlSessionFactoryRef = "librarySqlSessionTemplate")
public class MyBatisConfigLibrary {

    @Bean(name = "libraryDataSource")
    public DataSource libraryDataSource(DbConfigCourse dbConfigCourse) throws Exception {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL(dbConfigCourse.getUrl());
        mysqlXADataSource.setUser(dbConfigCourse.getUsername());
        mysqlXADataSource.setPassword(dbConfigCourse.getPassword());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("libraryDataSource");
        return mysqlXADataSource;
    }

    @Bean(name = "librarySqlSessionFactory")
    public SqlSessionFactory librarySqlSessionFactory(@Qualifier("libraryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "librarySqlSessionTemplate")
    public SqlSessionTemplate librarySqlSessionTemplate(@Qualifier("librarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
