package com.springboot;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 排除DruidDataSourceAutoConfigure的原因：需要使用自己配置的数据源
 */
@EnableAutoConfiguration(exclude = { DruidDataSourceAutoConfigure.class })
@SpringBootApplication
public class SpringbootDatasourceAutoselectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDatasourceAutoselectApplication.class, args);
    }

}
