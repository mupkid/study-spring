package com.example.security.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户身份信息
 */
@Data
@AllArgsConstructor
public class UserDto {

    public static final String SESSION_USER_KEY="_user";

    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
