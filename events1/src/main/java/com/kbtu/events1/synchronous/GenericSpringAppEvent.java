package com.kbtu.events1.synchronous;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class GenericSpringAppEvent<T> extends ApplicationEvent {

    private final T what;

    public GenericSpringAppEvent(final Object source, final T what) {
        super(source);
        this.what = what;
    }
}