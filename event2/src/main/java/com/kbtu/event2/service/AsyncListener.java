package com.kbtu.event2.service;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncListener {
    @Async
    @EventListener
    void handleAsyncEvent(String event) {
        // handle event
    }
}
