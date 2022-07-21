package org.ohx.studyspring;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.ohx.studyspring.config.SpringConfig;
import org.ohx.studyspring.dao.UserDao;
import org.ohx.studyspring.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mudkip
 * @date 2022/7/20
 */
public class JdbcTemplateTest {
    @Test
    public void getDatasourceBeanTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        DruidDataSource druidDataSource = applicationContext.getBean(DruidDataSource.class);
        System.out.println(druidDataSource);
        System.out.println(druidDataSource.getUsername());
    }

    @Test
    public void updateTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);
        User user = new User("张三", "123456", 20, "男");
        userDao.insert(user);
    }
}
