package org.ohx.studyspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author mudkip
 * @date 2022/7/20
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = ("org.ohx.studyspring"))
public class SpringConfig {
}
