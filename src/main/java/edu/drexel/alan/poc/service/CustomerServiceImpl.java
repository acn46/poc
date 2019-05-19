package edu.drexel.alan.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.drexel.alan.poc.model.Customer;
import edu.drexel.alan.poc.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo repo;
	
	public List<Customer> getAll() {
		return repo.findAll();
	}

	public Optional<Customer> findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public Customer insert(Customer customer) {
		// TODO Auto-generated method stub
		return repo.save(customer);
	}

	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return repo.save(customer);
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
