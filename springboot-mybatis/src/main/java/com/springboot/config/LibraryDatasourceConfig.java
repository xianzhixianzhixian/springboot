package com.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Autowired默认是根据类型Type来自动注入的。但有些特殊情况，对同一个接口，可能会有几种不同的实现类，而默认只会采取其中一种的情况下@Primary的作用就出来了
 * @Qualifier注解的用处：当一个接口有多个实现的时候，为了指名具体调用哪个类的实现
 */
@Configuration
@MapperScan(basePackages = "com.springboot.mapper.library", sqlSessionFactoryRef = "librarySqlSessionFactory")
public class LibraryDatasourceConfig {

    /**
     * 配置library数据源
     * @return
     */
    @Bean(name = "libraryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.library")
    public DataSource libraryDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * library sql会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "librarySqlSessionFactory")
    public SqlSessionFactory librarySqlSessionFactory(@Qualifier("libraryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/springboot/mapper/**/*.xml"));
        return bean.getObject();
    }

    /**
     * library事务管理
     */
    @Bean(name = "libraryTransactionManager")
    public DataSourceTransactionManager libraryDataSourceTransactionManager(@Qualifier("libraryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "librarySqlSessionTemplate")
    public SqlSessionTemplate librarySqlSessionTemplate(@Qualifier("librarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws  Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
