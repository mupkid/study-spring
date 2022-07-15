package org.ohx.springmvcsecurity.springmvc.controller;

import org.ohx.springmvcsecurity.springmvc.model.AuthenticationRequest;
import org.ohx.springmvcsecurity.springmvc.model.UserDto;
import org.ohx.springmvcsecurity.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login", produces = {"text/plain;charset=UTF-8"})
    public String login(AuthenticationRequest authenticationRequest){
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        return userDto.getUsername()+ "登录成功";
    }
}
