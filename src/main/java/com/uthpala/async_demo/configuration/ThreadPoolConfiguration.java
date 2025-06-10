package com.uthpala.async_demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfiguration {

    @Bean("threadPoolTaskExecutor")
    public TaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(5);                   // Minimum number of threads
        executor.setMaxPoolSize(10);                    // Maximum number of threads
        executor.setQueueCapacity(25);                  // Queue size before new threads are created
        executor.setWaitForTasksToCompleteOnShutdown(true); // Wait for tasks to finish on shutdown
        executor.setThreadNamePrefix("Async-Thread-");  // Thread name prefix for easier debugging

        return executor;
    }
}

