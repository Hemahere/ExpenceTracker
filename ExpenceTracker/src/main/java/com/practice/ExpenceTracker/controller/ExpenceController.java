package com.practice.ExpenceTracker.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.ExpenceTracker.dto.ExpenceDTO;
import com.practice.ExpenceTracker.entity.Expence;
import com.practice.ExpenceTracker.services.ExpenceService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expence")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpenceController {
	
	private final ExpenceService expenceService;
	 public ExpenceController(ExpenceService expenceService) {
	        this.expenceService = expenceService;
	    }
	
	 
	 
	
	@PostMapping
	public ResponseEntity<?> postExpence(@RequestBody ExpenceDTO dto){
	Expence createdExpence = expenceService.postExpence(dto);
	
	
	if(createdExpence != null) {
		 return ResponseEntity.status(HttpStatus.CREATED).body(createdExpence);
	}
	else{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	 
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllExpence(){
		return ResponseEntity.ok(expenceService.getAllExpences());		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getExpenceById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(expenceService.getExpenceById(id));
					
		}catch(EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateExpence(@PathVariable Long id,@RequestBody ExpenceDTO dto){
		try {
			return ResponseEntity.ok(expenceService.updateExpence(id,dto));
					
		}catch(EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");}
		
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteExpence(@PathVariable Long id){
		try {
			expenceService.deleteExpence(id);
			return ResponseEntity.ok(null);
					
		}catch(EntityNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");}
		
	}
}
