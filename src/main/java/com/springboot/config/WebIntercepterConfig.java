package com.springboot.config;

import com.springboot.aop.LoginIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器生效的类
 */
@Configuration
public class WebIntercepterConfig {

    @Autowired
    private LoginIntercepter loginIntercepter;

    @Bean
    public WebMvcConfigurer config() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(loginIntercepter);
            }
        };
    }
}
