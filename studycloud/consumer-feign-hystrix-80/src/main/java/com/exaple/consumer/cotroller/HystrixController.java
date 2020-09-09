package com.exaple.consumer.cotroller;

import com.exaple.consumer.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/hystrix/ok/{id}")
    public String infoOk(@PathVariable("id") Integer id) {
        return hystrixService.infoOk(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String infoTimeout(@PathVariable("id") Integer id) {
        return hystrixService.infoTimeout(id);
    }
}
