package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExpenseDO {

    private Long id;
    private BigDecimal amount;
    private String category;
    private String description;
    private LocalDateTime date;
}
