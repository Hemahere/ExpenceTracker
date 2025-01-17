package com.practice.ExpenceTracker.entity;

import java.time.LocalDate;

import com.practice.ExpenceTracker.dto.IncomeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Income {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private Integer amount;
	
	private String category;
	
	private LocalDate date;
	
	private String description;
	
	
	private String title;
	
	
	
	
	
	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getAmount() {
		return amount;
	}
	

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	
	


	public IncomeDTO getIncomeDTO() {
		IncomeDTO incomeDTO= new IncomeDTO();
		
		incomeDTO.setId(id);
		incomeDTO.setAmount(amount);
		incomeDTO.setCategory(category);
		incomeDTO.setDate(date);
		incomeDTO.setDescription(description);
		incomeDTO.setTitle(title);
		
		return incomeDTO;
	}


	

}
