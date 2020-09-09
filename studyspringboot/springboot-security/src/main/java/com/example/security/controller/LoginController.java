package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    @RequestMapping(value = "/login-success", produces = "text/plain;charset=UTF-8")
    public String loginSuccess() {
        return "登录成功";
    }

    @GetMapping(value = "/r/r1", produces = "text/plain;charset=UTF-8")
    public String r1() {
        return "访问资源1";
    }

    @GetMapping(value = "/r/r2", produces = "text/plain;charset=UTF-8")
    public String r2() {
        return "访问资源2";
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/user/index")
    public String userIndex() {
        return "user/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
