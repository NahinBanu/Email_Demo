package com.nahin.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nahin.demo.model.EmailUser;

@Repository
public interface EmailUserRepo extends JpaRepository<EmailUser, Integer> {
	@Query("SELECT e FROM EmailUser e WHERE e.ename=:name and e.pass = :pass")
	EmailUser findByName(String name, String pass);

	@Query("SELECT e FROM EmailUser e WHERE e.ename=:to")
	EmailUser findBy(String to);
	

}
