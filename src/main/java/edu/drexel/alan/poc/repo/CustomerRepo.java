package edu.drexel.alan.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.drexel.alan.poc.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
