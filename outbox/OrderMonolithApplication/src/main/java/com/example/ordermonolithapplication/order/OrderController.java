package com.example.ordermonolithapplication.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderManagement orders;

    public OrderController(OrderManagement orders) {
        this.orders = orders;
    }

    @PostMapping("/orders/")
    public ResponseEntity<Order> createOrder(@RequestBody String product) {
        var order = orders.create(product);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> viewOrders() {
        return ResponseEntity.ok(orders.fetch());
    }

    @PutMapping("/orders/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody String newProduct) {
        var updatedOrder = orders.update(orderId, newProduct);
        return ResponseEntity.ok(updatedOrder);
    }
}
