package org.ohx.provider8002.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.ohx.provider8002.dao.UserDao;
import org.ohx.provider8002.entity.User;
import org.ohx.provider8002.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public int saveReturnEffect(User entity) {
        return getBaseMapper().insert(entity);
    }
}
