package com.exaple.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider2")
public interface HystrixService {
    @GetMapping("/hystrix/ok/{id}")
    public String infoOk(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/timeout/{id}")
    public String infoTimeout(@PathVariable("id") Integer id);
}
