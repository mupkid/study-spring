package org.ohx.springbootasync.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Async
    public void asyncMethodWithDefaultThreadPool() {
        System.out.println("开始执行异步方法，线程：" + Thread.currentThread().getName() + "，时间："
                + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行异步方法结束，时间：" + System.currentTimeMillis());
    }

    @Async("myThreadPool")
    public void asyncMethodWithCustomThreadPool() {
        System.out.println("开始执行异步方法，线程：" + Thread.currentThread().getName() + "，时间："
                + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行异步方法结束，时间：" + System.currentTimeMillis());
    }
}
