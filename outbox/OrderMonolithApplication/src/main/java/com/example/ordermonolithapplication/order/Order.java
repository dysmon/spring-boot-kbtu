package com.example.ordermonolithapplication.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order(String product) {
        this.product = product;
        this.status = OrderStatus.CREATED;
    }

    public enum OrderStatus {
        CREATED, COMPLETED, UPDATED
    }


}

