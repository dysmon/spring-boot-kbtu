package com.example.casbinexample.model;

public record Data(
        String source,
        String data,
        long timestamp,
        String state
) {
}
