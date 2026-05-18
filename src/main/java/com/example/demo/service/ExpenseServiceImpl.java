package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ExpenseDO;
import com.example.demo.dto.ExpenseVM;
import com.example.demo.entity.Expense;
import com.example.demo.mapper.ExpenseMapper;
import com.example.demo.repository.ExpenseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    
	private static final Logger log = LoggerFactory.getLogger(ExpenseServiceImpl.class);
	
	@Autowired
    private ExpenseRepository repo;
	
	@Autowired
    private ExpenseMapper mapper;
	
    // Save a new expense to the database
    @Override
    public ExpenseDO saveExpense(ExpenseVM vm) {
    	Expense entity = mapper.toEntity(vm);
        return mapper.toDO(repo.save(entity));
    }

    // Retrieve all expenses for the dashboard
	@Override
    public List<ExpenseDO> getAllExpenses() {
        List<Expense> rawList = repo.findAll();
        List<ExpenseDO> resultList = mapper.toDOList(rawList);
        return resultList;
    }
	
	// Delete an expense by its ID
    public void deleteExpense(Long id) {
    	repo.deleteById(id);
    }

}
