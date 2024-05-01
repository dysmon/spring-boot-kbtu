package com.example.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@SpringBootApplication
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @KafkaListener(topics = "#{'${notification.order-created-kafka-topic}'}", groupId = "#{'${notification.group-id}'}", containerFactory = "kafkaListenerContainerFactoryJson1")
    public void notify(OrderCreated event) {
        log.info("Notifying user for created order {} and product {}", event.id(), event.product());
    }

    @KafkaListener(topics = "#{'${notification.order-updated-kafka-topic}'}", groupId = "#{'${notification.group-id}'}", containerFactory = "kafkaListenerContainerFactoryJson2")
    public void notify(OrderUpdated event) {
        log.info("Notifying user for updated order {} and product {}", event.id(), event.product());
    }

}

