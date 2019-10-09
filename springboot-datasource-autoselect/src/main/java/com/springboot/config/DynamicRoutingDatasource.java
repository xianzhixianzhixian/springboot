package com.springboot.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态路由数据源
 * AbstractRoutingDataSource：该类充当了DataSource的路由中介,能在运行时根据某种key值来动态切换到真正的DataSource上
 */
public class DynamicRoutingDatasource extends AbstractRoutingDataSource {
    //这里就已经获得了dataSource了
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDatasourceContextHolder.get();
    }
}
