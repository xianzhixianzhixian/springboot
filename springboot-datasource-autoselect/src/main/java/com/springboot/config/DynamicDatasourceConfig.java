package com.springboot.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 核心代码
 */
@MapperScan(basePackages = "com.springboot.mapper")
@Configuration
public class DynamicDatasourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.course")
    public DataSource courseDatasource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.library")
    public DataSource libraryDatasource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 核心动态数据源配置
     */
    @Bean
    public DataSource dynamicDatasource() {
        DynamicRoutingDatasource routingDatasource = new DynamicRoutingDatasource();
        Map<Object, Object> datasourceMap = new HashMap<>(2);
        //设置默认数据源
        routingDatasource.setDefaultTargetDataSource(courseDatasource());

        //配置数据源
        datasourceMap.put(AreaKeyId.BEIJING, courseDatasource());
        datasourceMap.put(AreaKeyId.CHENGDU, libraryDatasource());
        routingDatasource.setTargetDataSources(datasourceMap);
        return routingDatasource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDatasource());
        //解决找不到mapper.xml问题
//        sqlSessionFactoryBean.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResource("classpath*:mapping/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    /**
     * 事务管理
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dynamicDatasource());
    }
}
