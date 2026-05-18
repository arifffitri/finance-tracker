package com.example.demo.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ExpenseVM {

    private BigDecimal amount;
    private String category;
    private String description;
    private String date;
}
