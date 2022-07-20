package org.ohx.studyspring;

import org.junit.jupiter.api.Test;
import org.ohx.studyspring.config.SpringConfig;
import org.ohx.studyspring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mudkip
 * @date 2022/7/19
 */
public class BeanTest {
    @Test
    public void test1() {
        // ClassPathXmlApplicationContext 读取 XML 配置文件的配置作为Bean
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }

    @Test
    public void test2() {
        // AnnotationConfigApplicationContext 直接扫描指定包中所有带了注解的Bean
        ApplicationContext context = new AnnotationConfigApplicationContext("org.ohx.studyspring");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }

    @Test
    public void test3() {
        // AnnotationConfigApplicationContext 指定配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
