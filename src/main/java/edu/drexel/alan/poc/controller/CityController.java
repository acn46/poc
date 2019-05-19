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

import edu.drexel.alan.poc.model.City;
import edu.drexel.alan.poc.service.CityService;

@RestController
public class CityController {

	@Autowired
	private CityService service;
	
	@GetMapping("/cities")
	public List<City> getAll() {
		System.out.println("\nin getAll");
		List<City> list = service.getAll();
		return list;

	}
	
	@GetMapping("/city/{id}")
	public City findByID(@PathVariable("id") int id) {
		System.out.println("\nin findByID "+id);
		Optional<City> returnValue = service.findById(id);
		return returnValue.get();
	}
	
	@PostMapping("/city/insert")
	public @ResponseBody int insert(@RequestBody City city) {
		System.out.println("\nin Insert");
		//City newCity = new City("John", "Doe", 1, "", "John@compmail.com", 2, 1, "JDoe", "dwe23321", null);
		City updatedCity = service.insert(city);
		return updatedCity.getCityId();
	}
	
	@PostMapping("/city/update")
	public @ResponseBody int update(@RequestBody City city) {
		System.out.println("\nin update");
		//City city = new City("John1", "Doe", 1, "John@compmail.com", null, 2, 1, "JDoe", "dwe23321", null);
		//city.setCityId(10);
		City updatedCity = service.update(city);
		return updatedCity.getCityId();
	}
	
	@DeleteMapping("/city/{id}")
	public int delete(@PathVariable("id") int id) {
		System.out.println("\nin delete");
		int rowAffected = service.delete(id);
		return rowAffected;
	}
	
}
