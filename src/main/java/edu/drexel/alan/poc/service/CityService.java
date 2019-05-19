package edu.drexel.alan.poc.service;

import java.util.List;
import java.util.Optional;

import edu.drexel.alan.poc.model.City;


public interface CityService {

	public List<City> getAll();
	
	public Optional<City> findById(int id);
	
	public City insert(City city);
	
	public City update(City city);
	
	public int delete(int id);
	
}
