package com.kbtu.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farewell {
    private String message;
    private Integer remainingMinutes;
}
