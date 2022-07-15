package org.ohx.springbootsecurity.dao;

import org.apache.ibatis.annotations.Mapper;
import org.ohx.springbootsecurity.entity.Role;
import org.ohx.springbootsecurity.entity.SysUser;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    public SysUser getUserByUsername(String username);
    public Role getRoleByUserId(Long userId);

}
