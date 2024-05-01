package com.example.ordermonolithapplication.order;

import org.springframework.modulith.events.Externalized;

@Externalized("order-updated::#{id()}")
public record OrderUpdated(Long id, String product) {
}
