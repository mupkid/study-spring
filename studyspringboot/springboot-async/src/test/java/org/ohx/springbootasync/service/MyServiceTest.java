package org.ohx.springbootasync.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyServiceTest {

    @Autowired
    private MyService myService;

    @Test
    void asyncMethodWithDefaultThreadPool() {
        myService.asyncMethodWithDefaultThreadPool();
    }

    @Test
    void asyncMethodWithCustomThreadPool() {
        myService.asyncMethodWithCustomThreadPool();
    }
}