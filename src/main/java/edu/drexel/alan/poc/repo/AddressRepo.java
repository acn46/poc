package edu.drexel.alan.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.drexel.alan.poc.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{
	
}
