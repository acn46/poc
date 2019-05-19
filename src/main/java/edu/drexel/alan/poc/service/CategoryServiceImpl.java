package edu.drexel.alan.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.drexel.alan.poc.model.Category;
import edu.drexel.alan.poc.repo.CategoryRepo;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	public CategoryRepo repo;
	
	public List<Category> getAll() {
		return repo.findAll();
	}

	public Optional<Category> findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public Category insert(Category category) {
		// TODO Auto-generated method stub
		return repo.save(category);
	}

	public Category update(Category category) {
		// TODO Auto-generated method stub
		return repo.save(category);
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
