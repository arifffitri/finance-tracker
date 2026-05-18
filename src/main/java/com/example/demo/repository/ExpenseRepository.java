package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	// Spring Data JPA automatically writes all basic SQL methods (Save, Delete, Find) for you!
}
