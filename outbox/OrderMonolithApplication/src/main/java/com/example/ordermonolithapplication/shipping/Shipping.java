//package com.example.ordermonolithapplication.shipping;
//
//import com.example.ordermonolithapplication.order.OrderCreated;
//
//import org.springframework.modulith.events.ApplicationModuleListener;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//
//
//@Slf4j
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class Shipping {
//
//    @ApplicationModuleListener
//    void on(OrderCreated event) {
//        ship(event.id());
//    }
//
//    private void ship(Long orderId) {
//        log.info("Started shipping for order {}", orderId);
//    }
//}
