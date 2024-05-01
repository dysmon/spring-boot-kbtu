package com.example.ordermonolithapplication.order;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class OrderManagement {

    private final OrderRepository orders;
    private final ApplicationEventPublisher events;

    public Order create(String product) {

        var order = orders.save(new Order(product));

        events.publishEvent(new OrderCreated(order.getId(), order.getProduct()));

        log.info("Order created");

        return order;
    }

    public Order update(Long orderId, String newProduct) {
        Optional<Order> order = orders.findById(orderId);

        if (order.isPresent()) {
            Order existingOrder = order.get();

            existingOrder.setProduct(newProduct);

            Order updatedOrder = orders.save(existingOrder);

            updatedOrder.setStatus(Order.OrderStatus.UPDATED);

            events.publishEvent(new OrderUpdated(updatedOrder.getId(), updatedOrder.getProduct()));

            log.info("Order updated");

            return updatedOrder;
        } else {
            throw new RuntimeException("Order not found with id: " + orderId);
        }
    }

    @Transactional(readOnly = true)
    public List<Order> fetch() {
        return orders.findAll();
    }


}