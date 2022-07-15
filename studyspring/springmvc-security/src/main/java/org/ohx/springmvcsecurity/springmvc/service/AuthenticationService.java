package org.ohx.springmvcsecurity.springmvc.service;

import org.ohx.springmvcsecurity.springmvc.model.AuthenticationRequest;
import org.ohx.springmvcsecurity.springmvc.model.UserDto;

/**
 * 认证服务
 */
public interface AuthenticationService {

    UserDto authentication(AuthenticationRequest authenticationRequest);
}
