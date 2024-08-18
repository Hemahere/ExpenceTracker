package com.practice.ExpenceTracker.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.practice.ExpenceTracker.dto.ExpenceDTO;
import com.practice.ExpenceTracker.dto.IncomeDTO;
import com.practice.ExpenceTracker.entity.Expence;
import com.practice.ExpenceTracker.entity.Income;
import com.practice.ExpenceTracker.repository.ExpenceRepository;
import com.practice.ExpenceTracker.repository.IncomeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
	
	private final IncomeRepository incomeRepository;
	
	
	public IncomeServiceImpl(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }
	
	
	public Income postIncome(IncomeDTO incomeDTO) {
		return saveOrUpdateIncome(new Income(), incomeDTO);
		
	}
	
	
	private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO) {
	
		income.setAmount(incomeDTO.getAmount());
		income.setCategory(incomeDTO.getCategory());
		income.setDate(incomeDTO.getDate());
		income.setDescription(incomeDTO.getDescription());
		income.setTitle(incomeDTO.getTitle());
		
		return incomeRepository.save(income); 
		
	}
	
	
	 public Income updateIncome(Long id,IncomeDTO incomeDTO) {
		 Optional<Income> optionalIncome = incomeRepository.findById(id);
		 if(optionalIncome.isPresent()) {
			 return saveOrUpdateIncome(optionalIncome.get(),incomeDTO);
		 }else {
			 throw new EntityNotFoundException("Income is not present with id"+id);
		 }
	 }
	
	public List<IncomeDTO> getAllIncomes() {
	    return incomeRepository.findAll().stream()
	            .sorted(Comparator.comparing(Income::getDate, Comparator.nullsLast(Comparator.naturalOrder())).reversed())
	            .map(Income::getIncomeDTO)
	            .collect(Collectors.toList());
	}
	
	public Income getIncomeById(Long id) {
		Optional<Income> optionalIncome= incomeRepository.findById(id);
		if(optionalIncome.isPresent()) {
			return optionalIncome.get();
		}
		else {
			throw new EntityNotFoundException("Income is not present with id "+ id);
		}
	}
	
	
	public void deleteIncome(Long id) {
		Optional<Income> optionalIncome = incomeRepository.findById(id);
		if(optionalIncome.isPresent()) {
			incomeRepository.deleteById(id);
		}
		else {
			throw new EntityNotFoundException("Income is not present with id" + id);
		}
	}
	

}
