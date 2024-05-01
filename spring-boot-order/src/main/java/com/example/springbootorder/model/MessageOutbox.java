package com.example.springbootorder.model;

import com.example.springbootorder.util.enums.MessageType;
import com.example.springbootorder.util.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageOutbox {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    @Column(columnDefinition = "TEXT")
    private String payload;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
