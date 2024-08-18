package com.practice.ExpenceTracker.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenceDTO {
	
	private Long id;
	
	private Integer amount;
	
	private String category;
	

	private LocalDate date;
	
	private String description;
	
	private String title;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

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
	
	
	
	

	}
	

