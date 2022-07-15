package org.ohx.springmvcsecurity.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 对应web.xml中ContextLoaderListener的配置
 * @author User
 */
@Configuration
@ComponentScan(basePackages = "org.ohx.security.springmvc",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {

    //在此配置除了Controller的其他bean，比如：数据库连接池、事务管理器、业务bean等

}
