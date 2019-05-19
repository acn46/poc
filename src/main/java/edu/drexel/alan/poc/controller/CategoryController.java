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

import edu.drexel.alan.poc.model.Category;
import edu.drexel.alan.poc.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@GetMapping("/categories")
	public List<Category> getAll() {
		System.out.println("\nin getAll");
		List<Category> list = service.getAll();
		return list;

	}
	
	@GetMapping("/category/{id}")
	public Category findByID(@PathVariable("id") int id) {
		System.out.println("\nin findByID "+id);
		Optional<Category> returnValue = service.findById(id);
		return returnValue.get();
	}
	
	@PostMapping("/category/insert")
	public @ResponseBody int insert(@RequestBody Category category) {
		System.out.println("\nin Insert");
		//Staff newStaff = new Staff("John", "Doe", 1, "", "John@compmail.com", 2, 1, "JDoe", "dwe23321", null);
		Category updatedCategory = service.insert(category);
		return updatedCategory.getCategoryId();
	}
	
	@PostMapping("/category/update")
	public @ResponseBody int update(@RequestBody Category category) {
		System.out.println("\nin update");
		//Staff staff = new Staff("John1", "Doe", 1, "John@compmail.com", null, 2, 1, "JDoe", "dwe23321", null);
		//staff.setStaffId(10);
		Category updatedCategory = service.update(category);
		return updatedCategory.getCategoryId();
	}
	
	@DeleteMapping("/category/{id}")
	public int delete(@PathVariable("id") int id) {
		System.out.println("\nin delete");
		int rowAffected = service.delete(id);
		return rowAffected;
	}
	
}
