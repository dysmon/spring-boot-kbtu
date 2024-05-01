package com.kbtu.event2.service;

import com.kbtu.event2.models.UserCreatedEvent;
import com.kbtu.event2.models.UserRemovedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Publisher {
    private final ApplicationEventPublisher publisher;

    Publisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishEvent(final String name) {
        publisher.publishEvent(new UserCreatedEvent(this, name));
        publisher.publishEvent(new UserRemovedEvent( name));
    }

}
