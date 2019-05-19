package edu.drexel.alan.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.drexel.alan.poc.model.Staff;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Integer>{
	
}
