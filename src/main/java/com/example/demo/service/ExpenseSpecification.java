package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.dto.ExpenseFilterDTO;
import com.example.demo.entity.Expense;

public class ExpenseSpecification {
	
	public static Specification<Expense> filterBy(ExpenseFilterDTO filter){
		return Specification
				.where(hasCategory(filter.getCategory()))
				.and(hasDescription(filter.getDescription()))
				.and(isAfterOrEqualTo(filter.getStartDate()))
				.and(isBeforeOrEqualTo(filter.getEndDate()));
	}

	public static Specification<Expense> hasCategory(String category){
		return (root, query, cb) -> (category == null || category.isBlank()) ? null 
				: cb.equal(root.get("category"), category);
	}
	
	private static Specification<Expense> hasDescription(String description) {
        return (root, query, cb) -> (description == null || description.isBlank()) ? null 
            : cb.like(cb.lower(root.get("description")), "%" + description.toLowerCase() + "%");
    }

    private static Specification<Expense> isAfterOrEqualTo(LocalDate startDate){
    	return (root, query, cb) -> startDate == null ? null 
    			: cb.greaterThanOrEqualTo(root.get("date"), startDate);
    }
    
    private static Specification<Expense> isBeforeOrEqualTo(LocalDate endDate){
    	return (root, query, cb) -> endDate == null ? null
    			: cb.lessThanOrEqualTo(root.get("date"), endDate);
    }
}
