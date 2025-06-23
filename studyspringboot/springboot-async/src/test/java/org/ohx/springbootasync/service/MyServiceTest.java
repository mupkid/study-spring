package org.ohx.springbootasync.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyServiceTest {

    @Autowired
    private MyService myService;

    @Test
    void asyncMethodWithDefaultThreadPool() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = myService.asyncMethodWithDefaultThreadPool();
        System.out.println(stringCompletableFuture.get());
    }

    @Test
    void asyncMethodWithCustomThreadPool() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = myService.asyncMethodWithDefaultThreadPool();
        System.out.println(stringCompletableFuture.get());
    }
}