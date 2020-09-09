package com.example.consumer.controller;

import com.example.common.CommonReturn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/")
public class BaseController {

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/info")
    public CommonReturn getUser(@RequestParam("id")String id){
        return restTemplate.getForObject("http://provider1/user/info/"+id, CommonReturn.class);
    }

    @GetMapping("/serverlist")
    public CommonReturn listServer(){
        List<String> services = discoveryClient.getServices();
        CommonReturn commonReturn = CommonReturn.success(200, "查询微服务列表成功");
        for (String service : services) {
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(service);
            commonReturn.put(service, serviceInstances);
        }
        return commonReturn;
    }
}
