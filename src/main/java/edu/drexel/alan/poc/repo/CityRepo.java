package edu.drexel.alan.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.drexel.alan.poc.model.City;

@Repository
public interface CityRepo extends JpaRepository<City, Integer>{

}
