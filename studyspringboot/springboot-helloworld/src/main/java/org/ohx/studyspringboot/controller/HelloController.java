package org.ohx.studyspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mudkip
 * @date 2022/7/24
 */
@RestController
public class HelloController {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World! by Spring Boot 2";
    }
}
