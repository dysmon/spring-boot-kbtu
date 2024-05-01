package kz.kbtu.backend.service;

import kz.kbtu.backend.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

public class GreetingService {
    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    public Greeting generateGreeting(String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
