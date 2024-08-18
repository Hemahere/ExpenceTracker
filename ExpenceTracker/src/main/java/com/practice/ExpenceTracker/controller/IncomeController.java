package com.practice.ExpenceTracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.ExpenceTracker.dto.ExpenceDTO;
import com.practice.ExpenceTracker.dto.IncomeDTO;
import com.practice.ExpenceTracker.entity.Income;
import com.practice.ExpenceTracker.services.ExpenceService;
import com.practice.ExpenceTracker.services.IncomeService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/income")
public class IncomeController {
 private final IncomeService incomeService;
 
 public IncomeController(IncomeService 	incomeService) {
     this.incomeService = incomeService;
 }  
 
 
 @PostMapping
 public ResponseEntity<?> postIncome(@RequestBody IncomeDTO incomeDTO){
	 Income createdIncome = incomeService.postIncome(incomeDTO);
	 if(createdIncome !=null) {
		 return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
	 }else {
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	 }
 }
 
 
 @GetMapping("/all")
 public ResponseEntity<?> getAllIncomes(){
	 return ResponseEntity.ok(incomeService.getAllIncomes());
	 
 }
 
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getIncomeById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(incomeService.getIncomeById(id));
					
		}catch(EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");}
		
	}
	
	
 
 @PutMapping("/{id}")
	public ResponseEntity<?> updateIncome(@PathVariable Long id,@RequestBody IncomeDTO dto){
		try {
			return ResponseEntity.ok(incomeService.updateIncome(id,dto));
					
		}catch(EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");}
		
	}
 
	
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteIncome(@PathVariable Long id){
	try {
		incomeService.deleteIncome(id);
		return ResponseEntity.ok(null);
				
	}catch(EntityNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}catch(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");}
	
}
}
