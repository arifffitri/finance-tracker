package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseFilterDTO {

    private String category;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
