package edu.drexel.alan.poc.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.drexel.alan.poc.model.Customer;
import edu.drexel.alan.poc.service.CustomerService;

public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customers")
	public List<Customer> getAll() {
		System.out.println("\nin getAll");
		List<Customer> list = service.getAll();
		return list;

	}
	
	@GetMapping("/customer/{id}")
	public Customer findByID(@PathVariable("id") int id) {
		System.out.println("\nin findByID "+id);
		Optional<Customer> returnValue = service.findById(id);
		return returnValue.get();
	}
	
	@PostMapping("/customer/insert")
	public @ResponseBody int insert(@RequestBody Customer customer) {
		System.out.println("\nin Insert");
		//Customer newCustomer = new Customer("John", "Doe", 1, "", "John@compmail.com", 2, 1, "JDoe", "dwe23321", null);
		Customer updatedCustomer = service.insert(customer);
		return updatedCustomer.getCustomerId();
	}
	
	@PostMapping("/customer/update")
	public @ResponseBody int update(@RequestBody Customer customer) {
		System.out.println("\nin update");
		//Customer customer = new Customer("John1", "Doe", 1, "John@compmail.com", null, 2, 1, "JDoe", "dwe23321", null);
		//customer.setCustomerId(10);
		Customer updatedCustomer = service.update(customer);
		return updatedCustomer.getCustomerId();
	}
	
	@DeleteMapping("/customer/{id}")
	public int delete(@PathVariable("id") int id) {
		System.out.println("\nin delete");
		int rowAffected = service.delete(id);
		return rowAffected;
	}
}
