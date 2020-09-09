package com.example.consumer;

import com.example.ribbonrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 *
 * RibbonClient注解用于定制访问某个微服务时采用的负载均衡规则，name表示微服务名称，configuration表示自定义规则类
 * @see RibbonClient
 */
@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient(name = "provider1", configuration = MyselfRule.class)
public class Consumer80 {

    public static void main(String[] args) {
        SpringApplication.run(Consumer80.class, args);
    }
}
