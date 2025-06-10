package com.uthpala.async_demo.controller;

import com.uthpala.async_demo.service.AsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class AsyncController {

    private final AsyncService asyncService;

    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/parallel-tasks")
    public String runParallelTasks() throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<String> taskOneFuture = asyncService.asyncTaskOne();
        CompletableFuture<String> taskTwoFuture = asyncService.asyncTaskTwo();
        CompletableFuture<String> taskThreeFuture = asyncService.asyncTaskThree();

        // Wait for all tasks to complete
        CompletableFuture.allOf(taskOneFuture, taskTwoFuture, taskThreeFuture).join();

        long end = System.currentTimeMillis();

        // Collect results
        String result = taskOneFuture.get() + " | " +
                taskTwoFuture.get() + " | " +
                taskThreeFuture.get();

        result += " | Total time: " + (end - start) + " ms";

        return result;
    }
}

