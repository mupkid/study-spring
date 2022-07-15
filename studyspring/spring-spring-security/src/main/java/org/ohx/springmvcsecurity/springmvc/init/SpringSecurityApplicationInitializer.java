package org.ohx.springmvcsecurity.springmvc.init;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Spring Security初始化，这里有两种情况
 * 若当前环境没有使用Spring或SpringMVC，则需要将WebSecurityConfig（Spring Security配置类）传入超类，以确保获取配置，并创建spring context
 * 若已使用spring，应该在现有的spring context中注册Spring Security，此方法可以什么都不做
 */
public class SpringSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public SpringSecurityApplicationInitializer(){

    }
}
