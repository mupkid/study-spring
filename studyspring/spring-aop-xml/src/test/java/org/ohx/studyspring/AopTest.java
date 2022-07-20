package org.ohx.studyspring;

import org.junit.jupiter.api.Test;
import org.ohx.studyspring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mudkip
 * @date 2022/7/20
 */
public class AopTest {
    @Test
    public void Test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
