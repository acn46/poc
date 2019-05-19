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
import org.springframework.web.bind.annotation.RestController;

import edu.drexel.alan.poc.model.Country;
import edu.drexel.alan.poc.service.CountryService;

@RestController
public class CountryController {
	@Autowired
	private CountryService service;
	
	@GetMapping("/countries")
	public List<Country> getAll() {
		System.out.println("\nin getAll");
		List<Country> list = service.getAll();
		return list;

	}
	
	@GetMapping("/country/{id}")
	public Country findByID(@PathVariable("id") int id) {
		System.out.println("\nin findByID "+id);
		Optional<Country> returnValue = service.findById(id);
		return returnValue.get();
	}
	
	@PostMapping("/country/insert")
	public @ResponseBody int insert(@RequestBody Country country) {
		System.out.println("\nin Insert");
		//Country newCountry = new Country("John", "Doe", 1, "", "John@compmail.com", 2, 1, "JDoe", "dwe23321", null);
		Country updatedCountry = service.insert(country);
		return updatedCountry.getCountryId();
	}
	
	@PostMapping("/country/update")
	public @ResponseBody int update(@RequestBody Country country) {
		System.out.println("\nin update");
		//Country country = new Country("John1", "Doe", 1, "John@compmail.com", null, 2, 1, "JDoe", "dwe23321", null);
		//country.setCountryId(10);
		Country updatedCountry = service.update(country);
		return updatedCountry.getCountryId();
	}
	
	@DeleteMapping("/country/{id}")
	public int delete(@PathVariable("id") int id) {
		System.out.println("\nin delete");
		int rowAffected = service.delete(id);
		return rowAffected;
	}
}
