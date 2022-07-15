package org.ohx.provider8001.controller;

import lombok.extern.slf4j.Slf4j;
import org.ohx.common.CommonReturn;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/feign")
public class FeignTestController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/timeout")
    public CommonReturn feignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return CommonReturn.error(500, "请求超时").put("serverPort", serverPort);
    }
}
