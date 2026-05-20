package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.ExpenseDO;
import com.example.demo.dto.ExpenseFilterDTO;
import com.example.demo.dto.ExpenseVM;

public interface ExpenseService {
	
	public ExpenseDO saveExpense(ExpenseVM vm);
	
	public Page<ExpenseDO> getExpensesPaginated(ExpenseFilterDTO filter, Pageable pageable);
	
	public void deleteExpense(Long id);
}
