package com.example.springbootorder.service;

import com.example.springbootorder.model.MessageOutbox;
import com.example.springbootorder.model.Order;
import com.example.springbootorder.repositories.MessageOutboxRepository;
import com.example.springbootorder.util.enums.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OutboxLogCreator {

    @Autowired
    private MessageOutboxRepository messageOutboxRepository;

    public void postLogOutbox(Order order) {
        insertLogIntoOutbox(order, MessageType.CREATED);
    }

    public void putLogOutbox(Order order) {
        insertLogIntoOutbox(order, MessageType.UPDATED);
    }

    public void deleteLogOutbox(Order order) {
        insertLogIntoOutbox(order, MessageType.DELETED);
    }

    private void insertLogIntoOutbox(Order order, MessageType eventType) {
        String payload = "Order ID: " + order.getId() + ", Event Type: " + eventType;
        MessageOutbox message = new MessageOutbox();

        message.setOrderId(order.getId());
        message.setMessageType(eventType);
        message.setPayload(payload);
        message.setCreatedAt(LocalDateTime.now());
        message.setStatus(order.getStatus());

        messageOutboxRepository.save(message);
    }
}
