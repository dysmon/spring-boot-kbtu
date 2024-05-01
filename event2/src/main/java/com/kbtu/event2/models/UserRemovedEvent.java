package com.kbtu.event2.models;

import lombok.Getter;

@Getter
public class UserRemovedEvent {
    private final String name;
    public UserRemovedEvent(String name) {
        this.name = name;
    }
}
