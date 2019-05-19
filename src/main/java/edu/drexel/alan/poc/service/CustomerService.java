package edu.drexel.alan.poc.service;

import java.util.List;
import java.util.Optional;

import edu.drexel.alan.poc.model.Customer;

public interface CustomerService {

	public List<Customer> getAll();
	
	public Optional<Customer> findById(int id);
	
	public Customer insert(Customer customer);
	
	public Customer update(Customer customer);
	
	public int delete(int id);
	
}
