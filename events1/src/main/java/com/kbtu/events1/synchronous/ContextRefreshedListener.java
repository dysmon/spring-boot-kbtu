package com.kbtu.events1.synchronous;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent cre) {
        System.out.println("Handling context re-freshed event. ");
    }
}
