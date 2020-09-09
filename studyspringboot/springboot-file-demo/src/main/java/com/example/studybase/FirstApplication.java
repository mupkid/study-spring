package com.example.studybase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.studybase.*.dao")
public class FirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class, args);

        String aaa = "aaaa";
        aaa.matches("^\\S*WA_BASIC_FJ_1001\\S*$");
    }
}
