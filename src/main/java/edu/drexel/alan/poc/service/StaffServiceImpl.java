package edu.drexel.alan.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.drexel.alan.poc.model.Staff;
import edu.drexel.alan.poc.repo.StaffRepo;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepo repo;
	
	@Override
	public List<Staff> getAll() throws ServiceException {
		return repo.findAll();
	}

	@Override
	public Optional<Staff> findById(int id) throws ServiceException {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Staff insert(Staff staff) throws ServiceException {
		// TODO Auto-generated method stub
		return repo.save(staff);
	}

	@Override
	public Staff update(Staff staff) throws ServiceException {
		// TODO Auto-generated method stub
		return repo.save(staff);
	}

	@Override
	public int delete(int id) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
