package com.example.springbootorder.model;

import com.example.springbootorder.service.OutboxLogCreator;
import com.example.springbootorder.util.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime date;

    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @PrePersist
    protected void onCreate() {
        date = LocalDateTime.now();
    }

}
