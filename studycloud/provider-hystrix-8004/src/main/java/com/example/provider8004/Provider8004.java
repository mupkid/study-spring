package com.example.provider8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Provider8004 {
    public static void main(String[] args) {
        SpringApplication.run(Provider8004.class, args);
    }
}
