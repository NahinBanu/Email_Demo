package com.nahin.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nahin.demo.model.Email;
@Repository
public interface EmailRepo  extends JpaRepository<Email, Integer> {
	
	@Query("SELECT e FROM Email e WHERE e.to = :to")
	List<Email> findByTo(String to);
	
	@Query("SELECT e FROM Email e WHERE e.from = :from")
	List<Email> findByFrom(String from);
	
}