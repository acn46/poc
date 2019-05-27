package edu.drexel.alan.poc.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.drexel.alan.poc.model.Staff;
import edu.drexel.alan.poc.service.ServiceException;
import edu.drexel.alan.poc.service.StaffService;
import edu.drexel.alan.poc.service.StaffServiceImpl;

@RestController
public class StaffController {
	
	private final static Logger logger = LoggerFactory.getLogger( StaffController.class );

	@Autowired
	private StaffService service;
	
	@GetMapping("/staffs")
	public List<Staff> getAll() {
		logger.debug("\nin getAll");
		List<Staff> list = null;
		try {
			list = service.getAll();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	
	@GetMapping("/staff/{id}")
	public Staff findByID(@PathVariable("id") int id) {
		logger.debug("\nin findByID "+id);
		Optional<Staff> returnValue = null;
		try {
			returnValue = service.findById(id);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue.get();
	}
	
	@PostMapping("/staff/insert")
	public @ResponseBody int insert(@RequestBody Staff staff) {
		logger.debug("\nin Insert");
		//Staff newStaff = new Staff("John", "Doe", 1, "", "John@compmail.com", 2, 1, "JDoe", "dwe23321", null);
		Staff updatedStaff = null;
		try {
			updatedStaff = service.insert(staff);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatedStaff.getStaffId();
	}
	
	@PostMapping("/staff/update")
	public @ResponseBody int update(@RequestBody Staff staff) {
		logger.debug("\nin update");
		//Staff staff = new Staff("John1", "Doe", 1, "John@compmail.com", null, 2, 1, "JDoe", "dwe23321", null);
		//staff.setStaffId(10);
		Staff updatedStaff = null;
		try {
			updatedStaff = service.update(staff);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatedStaff.getStaffId();
	}
	
	@DeleteMapping("/staff/{id}")
	public int delete(@PathVariable("id") int id) {
		logger.debug("\nin delete");
		int rowAffected = 0;
		try {
			rowAffected = service.delete(id);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowAffected;
	}

}
