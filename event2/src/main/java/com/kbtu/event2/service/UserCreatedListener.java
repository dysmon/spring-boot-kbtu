package com.kbtu.event2.service;

import com.kbtu.event2.models.UserCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
class UserCreatedListener implements ApplicationListener<UserCreatedEvent> {

    @Override
    public void onApplicationEvent(UserCreatedEvent event) {
        // handle UserCreatedEvent
    }
}
