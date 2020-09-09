package com.example.consumer.controller;

import com.example.common.CommonReturn;
import com.example.consumer.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
public class FeignController {

    @Autowired
    private FeignService feignService;

    @GetMapping("/user/info")
    public CommonReturn getUser(@RequestParam("id")Long id){
        return feignService.info(id);
    }

    @GetMapping("/feign/timeout")
    public CommonReturn feignTimeout(){
        //openfeign-ribbon，客户端一般默认等待1秒
        return feignService.feignTimeout();
    }

}
