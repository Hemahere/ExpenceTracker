package com.practice.ExpenceTracker.services;

import java.util.List;

import com.practice.ExpenceTracker.dto.IncomeDTO;
import com.practice.ExpenceTracker.entity.Income;

public interface IncomeService {
	
	 Income postIncome(IncomeDTO incomeDTO);
	 
	 List <IncomeDTO> getAllIncomes();
	 
	 Income updateIncome(Long id,IncomeDTO incomeDTO);
	 
	 Income getIncomeById(Long id);
	 
	 void deleteIncome(Long id);

}
