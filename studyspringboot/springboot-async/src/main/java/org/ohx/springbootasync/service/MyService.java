package org.ohx.springbootasync.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
public class MyService {

    @Async
    public CompletableFuture<String> asyncMethodWithDefaultThreadPool() {
        System.out.println("开始执行异步方法，线程：" + Thread.currentThread().getName() + "，时间："
                + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行异步方法结束，时间：" + System.currentTimeMillis());
        return CompletableFuture.completedFuture("异步方法执行完成");
    }

    @Async("myThreadPool")
    public CompletableFuture<String> asyncMethodWithCustomThreadPool() {
        System.out.println("开始执行异步方法，线程：" + Thread.currentThread().getName() + "，时间："
                + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行异步方法结束，时间：" + System.currentTimeMillis());
        return CompletableFuture.completedFuture("异步方法执行完成");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Async("myThreadPool")
    public void transactionalMethod() {
        System.out.println("执行异步的事务方法");
    }
}
