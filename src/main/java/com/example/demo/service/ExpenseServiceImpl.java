package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ExpenseDO;
import com.example.demo.dto.ExpenseFilterDTO;
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
	public Page<ExpenseDO> getExpensesPaginated(ExpenseFilterDTO filter, Pageable pageable) {
		// Combine dynamic filters
		Specification<Expense> spec = ExpenseSpecification.filterBy(filter);
		
		// Fetch paginated entities from the DB
		Page<Expense> entityPage = repo.findAll(spec, pageable);
		
		// Map list content to DTOs/DOs
		List<ExpenseDO> list = mapper.toDOList(entityPage.getContent());
		
		// Return a new Page object containing metadata (total elements, total pages)
		return new PageImpl<>(list, pageable, entityPage.getTotalElements());
	}
	
	// Delete an expense by its ID
    public void deleteExpense(Long id) {
    	repo.deleteById(id);
    }

}
