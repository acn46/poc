package edu.drexel.alan.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.drexel.alan.poc.model.Staff;

@Service
public interface StaffService {

	public List<Staff> getAll() throws ServiceException;
	
	public Optional<Staff> findById(int id) throws ServiceException;
	
	public Staff insert(Staff staff) throws ServiceException;
	
	public Staff update(Staff staff) throws ServiceException;
	
	public int delete(int id) throws ServiceException;
	
}
