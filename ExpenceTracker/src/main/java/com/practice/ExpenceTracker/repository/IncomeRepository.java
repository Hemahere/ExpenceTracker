package com.practice.ExpenceTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.ExpenceTracker.entity.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Long> {

}
