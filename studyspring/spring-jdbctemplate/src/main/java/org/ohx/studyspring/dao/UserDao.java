package org.ohx.studyspring.dao;

import org.ohx.studyspring.entity.User;

/**
 * @author mudkip
 * @date 2022/7/21
 */
public interface UserDao {
    /**
     * 插入数据
     *
     * @param user 数据
     */
    void insert(User user);
}
