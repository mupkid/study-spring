package com.example.security.springmvc.init;

import com.example.security.springmvc.config.ApplicationConfig;
import com.example.security.springmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * SpringApplicationInitializer相当于web.xml，使用了Servlet3.0开发则不需要再定义web.xml
 * 该类相当于配置以下的web.xml文件
 * <web-app xmlns="http://java.sun.com/xml/ns/j2ee" version="2.4">
 * <listener>
 * <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
 * </listener>
 * <context-param>
 * <param-name>contextConfigLocation</param-name>
 * <param-value>/WEB-INF/application-context.xml</param-value>
 * </context-param>
 *
 * <servlet>
 * <servlet-name>springmvc</servlet-name>
 * <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
 * <init-param>
 * <param-name>contextConfigLocation</param-name>
 * <param-value>/WEB-INF/spring-mvc.xml</param-value>
 * </init-param>
 * <load-on-startup>1</load-on-startup>
 * </servlet>
 * <servlet-mapping>
 * <servlet-name>springmvc</servlet-name>
 * <url-pattern>/</url-pattern>
 * </servlet-mapping>
 * </web-app>
 *
 * @author User
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * spring容器，相当于加载applicationContext.xml
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }

    /**
     * servletContext，相当于加载springmvc.xml
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * url-mapping
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
