package com.example.provider8004.controller;

import com.example.provider8004.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/")
public class HystrixController {
    @Autowired
    private HystrixService hystrixService;

    @Value("${server.port")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String infoOk(@PathVariable("id") Integer id){
        String result= hystrixService.info_ok(id);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String infoTimeout(@PathVariable("id") Integer id){
        String result= hystrixService.timeout(id);
        return result;
    }
}
