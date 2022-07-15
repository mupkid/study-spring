package org.ohx.provider8001.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.ohx.provider8001.entity.User;

public interface UserService extends IService<User> {

    public int saveReturnEffect(User entity);
}
