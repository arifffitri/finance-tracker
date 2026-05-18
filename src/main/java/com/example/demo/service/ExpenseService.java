package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ExpenseDO;
import com.example.demo.dto.ExpenseVM;
import com.example.demo.entity.Expense;

public interface ExpenseService {
	
	public ExpenseDO saveExpense(ExpenseVM vm);
	
	public List<ExpenseDO> getAllExpenses();
	
	public void deleteExpense(Long id);
}
