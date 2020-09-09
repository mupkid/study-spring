package com.example.provider8003.controller;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.example.common.CommonReturn;
import com.example.provider8003.entity.User;
import com.example.provider8003.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/info/{id}")
    public CommonReturn info(@PathVariable(value = "id", required = true)Long id) {
        return CommonReturn.success(200, "查询成功 Server Port: " +serverPort).put("user", userService.getById(id));
    }

    @PostMapping("save")
    public CommonReturn save(User user) {
        int affectRows = userService.saveReturnEffect(user);
        if (SqlHelper.retBool(affectRows)) {
            return CommonReturn.success(200, "插入数据成功").put("affectRows", affectRows);
        } else {
            return CommonReturn.error(500, "插入数据失败");
        }
    }
}
