package org.ohx.springbootsecurity.service;

import org.ohx.springbootsecurity.dao.UserDao;
import org.ohx.springbootsecurity.entity.Role;
import org.ohx.springbootsecurity.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 连接数据库根据账号查询用户信息
        SysUser sysUser = userDao.getUserByUsername(username);
        if(sysUser == null){
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }

        Role role = userDao.getRoleByUserId(sysUser.getId());
        return User.withUsername(sysUser.getUsername()).password(sysUser.getPassword()).roles(role.getRoleName()).build();
    }
}
