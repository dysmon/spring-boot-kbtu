package com.example.ordermonolithapplication.order;

import org.springframework.modulith.events.Externalized;

@Externalized("order-created::#{id()}")
public record OrderCreated(Long id, String product) {
}
