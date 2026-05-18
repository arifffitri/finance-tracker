package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.ExpenseDO;
import com.example.demo.dto.ExpenseVM;
import com.example.demo.entity.Expense;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

	Expense toEntity(ExpenseVM vm);
	
	ExpenseDO toDO(Expense entity);
	
	List<ExpenseDO> toDOList(List<Expense> expenseList);
}
