package com.kbtu.event2.service;

import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;

public class SpringBuiltInEventListener implements ApplicationListener<SpringApplicationEvent> {

    @Override
    public void onApplicationEvent(SpringApplicationEvent event) {
        // handle event
    }
}
