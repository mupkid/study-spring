package com.example.security.springmvc.service;

import com.example.security.springmvc.model.AuthenticationRequest;
import com.example.security.springmvc.model.UserDto;

/**
 * 认证服务
 */
public interface AuthenticationService {

    UserDto authentication(AuthenticationRequest authenticationRequest);
}
