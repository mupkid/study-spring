package org.ohx.studyspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author mudkip
 * @date 2022/7/24
 */
@SpringBootApplication
public class HelloWorldApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HelloWorldApplication.class, args);
    }
}
