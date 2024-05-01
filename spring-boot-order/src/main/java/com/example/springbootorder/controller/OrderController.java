package com.example.springbootorder.controller;

import com.example.springbootorder.model.Order;
import com.example.springbootorder.repositories.OrderRepository;
import com.example.springbootorder.service.OutboxLogCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final OutboxLogCreator outboxLogCreator;

    // Get all orders
    @GetMapping("/orders/")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Get order by ID
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.map(order -> new ResponseEntity<>(order, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new order
    @PostMapping("/orders/")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        outboxLogCreator.postLogOutbox(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    // Update an existing order
    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            outboxLogCreator.putLogOutbox(updatedOrder);
            updatedOrder.setId(id);
            Order savedOrder = orderRepository.save(updatedOrder);
            return new ResponseEntity<>(savedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an order
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            outboxLogCreator.deleteLogOutbox(new Order());
            orderRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
