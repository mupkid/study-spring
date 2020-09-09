package com.example.provider8002.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provider8002.entity.User;

public interface UserService extends IService<User> {

    public int saveReturnEffect(User entity);
}
