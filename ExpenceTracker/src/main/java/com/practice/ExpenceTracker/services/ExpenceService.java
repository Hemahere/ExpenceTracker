package com.practice.ExpenceTracker.services;

import java.util.List;

import com.practice.ExpenceTracker.dto.ExpenceDTO;
import com.practice.ExpenceTracker.entity.Expence;

public interface ExpenceService {
	
	Expence postExpence(ExpenceDTO dto);
	
	
	
	
	 List <Expence> getAllExpences();
	 
	 
	 Expence getExpenceById(Long id);
	 
	 
	 Expence updateExpence(Long id,ExpenceDTO expenceDTO) ;
	 
	 void deleteExpence(Long id);
	 
	

}