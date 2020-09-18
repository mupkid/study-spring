package com.example.security.dao;

import com.example.security.entity.Role;
import com.example.security.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    public SysUser getUserByUsername(String username);
    public Role getRoleByUserId(Long userId);

}
