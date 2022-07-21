package org.ohx.studyspring.dao.impl;

import org.ohx.studyspring.dao.UserDao;
import org.ohx.studyspring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author mudkip
 * @date 2022/7/21
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(User user) {
        int update = jdbcTemplate.update("insert into user(username,password, age, sex) value(?,?,?,?)",
            user.getUsername(), user.getPassword(), user.getAge(), user.getSex());
        System.out.println(update);
    }
}
