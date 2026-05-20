package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ExpenseDO;
import com.example.demo.dto.ExpenseFilterDTO;
import com.example.demo.dto.ExpenseVM;
import com.example.demo.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Object> addExpense(@RequestBody ExpenseVM vm) {
    	ExpenseDO savedExpense = expenseService.saveExpense(vm);
        return ResponseEntity.ok().body(savedExpense);
    }

    @GetMapping
    public ResponseEntity<Page<ExpenseDO>> getAllExpenses(
    		ExpenseFilterDTO filters,
    		@PageableDefault(size = 20, sort = "date", direction = Sort.Direction.DESC) Pageable pageable) {
        
    	Page<ExpenseDO> response = expenseService.getExpensesPaginated(filters, pageable);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully!");
    }
}
