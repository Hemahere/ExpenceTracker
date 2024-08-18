package com.practice.ExpenceTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.ExpenceTracker.entity.Expence;

@Repository
public interface ExpenceRepository extends JpaRepository<Expence,Long> {
	

}
