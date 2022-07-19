package org.ohx.springhelloworld;

import org.junit.jupiter.api.Test;
import org.ohx.studyspring.entity.Course;
import org.ohx.studyspring.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mudkip
 * @date 2022/7/15
 */
public class BeanTest {
    @Test
    public void test1() {
        // 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 获取配置创建的对象
        User user = context.getBean("user", User.class);

        System.out.println(user);
    }

    @Test
    public void test2() {
        // 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 获取配置创建的对象
        Course course = context.getBean("myFactoryBean", Course.class);

        System.out.println(course);
    }
}
