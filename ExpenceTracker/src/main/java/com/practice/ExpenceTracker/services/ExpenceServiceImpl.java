package com.practice.ExpenceTracker.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.practice.ExpenceTracker.dto.ExpenceDTO;
import com.practice.ExpenceTracker.entity.Expence;
import com.practice.ExpenceTracker.repository.ExpenceRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ExpenceServiceImpl implements ExpenceService {
	
	
	private final ExpenceRepository expenceRepository;
	public ExpenceServiceImpl(ExpenceRepository expenceRepository) {
        this.expenceRepository = expenceRepository;
    }
	public Expence postExpence(ExpenceDTO expenceDTO) {
		return saveOrUpdateExpence(new Expence(), expenceDTO);
		
	}
	
	private Expence saveOrUpdateExpence(Expence expence, ExpenceDTO expenceDTO) {
		expence.setAmount(expenceDTO.getAmount());
		expence.setCatagory(expenceDTO.getCategory());
		expence.setDate(expenceDTO.getDate());
		expence.setDescription(expenceDTO.getDescription());
		expence.setTitle(expenceDTO.getTitle());
		
		return expenceRepository.save(expence);
		
		
	}
	
	
	 public Expence updateExpence(Long id,ExpenceDTO expenceDTO) {
		 Optional<Expence> optionalExpence = expenceRepository.findById(id);
		 if(optionalExpence.isPresent()) {
			 return saveOrUpdateExpence(optionalExpence.get(),expenceDTO);
		 }else {
			 throw new EntityNotFoundException("Expencde is not present with id"+id);
		 }
	 }
	
	 
	 
	public List <Expence> getAllExpences(){
		return expenceRepository.findAll().stream().sorted(Comparator.comparing(Expence::getDate,Comparator.nullsLast(Comparator.naturalOrder())).reversed())
				.collect(Collectors.toList());
		
	}
	
	
	public Expence getExpenceById(Long id) {
		Optional<Expence> optionalExpence= expenceRepository.findById(id);
		if(optionalExpence.isPresent()) {
			return optionalExpence.get();
		}
		else {
			throw new EntityNotFoundException("Expence is not present with id "+ id);
		}
	}
	
	
	public void deleteExpence(Long id) {
		Optional<Expence> optionalExpence = expenceRepository.findById(id);
		if(optionalExpence.isPresent()) {
			expenceRepository.deleteById(id);
		}
		else {
			throw new EntityNotFoundException("Expence is not present with id" + id);
		}
	}
	

}
