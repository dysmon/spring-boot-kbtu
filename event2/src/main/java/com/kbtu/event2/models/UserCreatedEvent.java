package com.kbtu.event2.models;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserCreatedEvent extends ApplicationEvent {
    private final String name;
    public UserCreatedEvent(Object source, String name) {
        super(source);
        this.name = name;
    }
}
