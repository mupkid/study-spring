package com.example.provider8004.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixService {

    public String info_ok(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " ok， id: " + id + "\t";
    }

    public String timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " timeout， id: " + id + "\t";
    }
}
