package org.ohx.springbootasync.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {

    @Bean("myThreadPool")
    public ThreadPoolExecutor asyncThreadPool() {
        return new ThreadPoolExecutor(
                10,
                20,
                1000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1000),
                r -> new Thread(r, "myThreadPool"),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
