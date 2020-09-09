package com.example.ribbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Ribbon负载均衡规则，用于替换Ribbon默认的规则
 * 该类不能放在@ComponetScan所扫描的当前包及子包下
 * 否则自定义配置类会被所有Ribbon客户端所共享，达不到特殊化定制的目的
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
