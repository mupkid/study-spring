package org.ohx.provider8003.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.ohx.provider8003.dao.UserDao;
import org.ohx.provider8003.entity.User;
import org.ohx.provider8003.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public int saveReturnEffect(User entity) {
        return getBaseMapper().insert(entity);
    }
}
