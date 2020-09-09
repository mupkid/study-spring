package com.example.consumer.service;

import com.example.common.CommonReturn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider1")
public interface FeignService {

    @GetMapping("/user/info/{id}")
    public CommonReturn info(@PathVariable(value = "id", required = true) Long id);

    @GetMapping("/feign/timeout")
    public CommonReturn feignTimeout();
}
