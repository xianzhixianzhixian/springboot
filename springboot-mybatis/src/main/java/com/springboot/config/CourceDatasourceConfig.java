//package com.springboot.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * @Autowired默认是根据类型Type来自动注入的。但有些特殊情况，对同一个接口，可能会有几种不同的实现类，而默认只会采取其中一种的情况下@Primary的作用就出来了
// * @Qualifier注解的用处：当一个接口有多个实现的时候，为了指名具体调用哪个类的实现
// * @Primary的作用当一个bean有多个候选者，则会挑选被标注为@Primary的bean，否则会报错
// */
//@Configuration
//@MapperScan(basePackages = "com.springboot.mapper.course", sqlSessionFactoryRef = "courseSqlSessionFactory")
//public class CourceDatasourceConfig {
//
//    /**
//     * 配置course数据源
//     * @return
//     */
//    @Bean(name = "courseDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.course")
//    @Primary
//    public DataSource courseDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     * course sql会话工厂
//     * @param dataSource
//     * @return
//     * @throws Exception
//     */
//    @Bean(name = "courseSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory courseSqlSessionFactory(@Qualifier("courseDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/springboot/mapper/**/*.xml"));
//        return bean.getObject();
//    }
//
//    /**
//     * course事务管理
//     */
//    @Bean(name = "courseTransactionManager")
//    @Primary
//    public DataSourceTransactionManager courseDataSourceTransactionManager(@Qualifier("courseDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "courseSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate courseSqlSessionTemplate(@Qualifier("courseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws  Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
