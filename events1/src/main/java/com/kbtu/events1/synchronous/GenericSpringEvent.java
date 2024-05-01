package com.kbtu.events1.synchronous;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class GenericSpringEvent <T> extends ApplicationEvent {
    private final T what;
    protected boolean success;

    public GenericSpringEvent(T what, boolean success) {
        super(what);
        this.what = what;
        this.success = success;
    }
}
