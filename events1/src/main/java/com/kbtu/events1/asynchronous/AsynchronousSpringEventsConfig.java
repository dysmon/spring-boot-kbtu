package com.kbtu.events1.asynchronous;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
@ComponentScan("com.kbtu.events1.synchronous")
public class AsynchronousSpringEventsConfig {
    @Bean
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        var eventMulticaster = new SimpleApplicationEventMulticaster();

        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }
}
