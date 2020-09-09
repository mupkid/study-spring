package com.example.provider8001.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provider8001.dao.UserDao;
import com.example.provider8001.entity.User;
import com.example.provider8001.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public int saveReturnEffect(User entity) {
        return getBaseMapper().insert(entity);
    }
}
