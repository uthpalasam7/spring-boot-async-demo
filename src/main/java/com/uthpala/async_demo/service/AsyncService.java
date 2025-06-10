package com.uthpala.async_demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> asyncTaskOne() {
        simulateDelay(2000);
        return CompletableFuture.completedFuture("Task One Completed");
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> asyncTaskTwo() {
        simulateDelay(3000);
        return CompletableFuture.completedFuture("Task Two Completed");
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> asyncTaskThree() {
        simulateDelay(1000);
        return CompletableFuture.completedFuture("Task Three Completed");
    }

    private void simulateDelay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


