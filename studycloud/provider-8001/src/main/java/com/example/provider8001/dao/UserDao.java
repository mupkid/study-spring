package com.example.provider8001.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.provider8001.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao extends BaseMapper<User> {
}
