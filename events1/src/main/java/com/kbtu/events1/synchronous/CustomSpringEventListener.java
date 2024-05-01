package com.kbtu.events1.synchronous;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {
    public void onApplicationEvent(CustomSpringEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage());
    }
}
