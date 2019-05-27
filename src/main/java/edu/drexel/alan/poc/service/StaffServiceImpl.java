package edu.drexel.alan.poc.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.drexel.alan.poc.model.Staff;
import edu.drexel.alan.poc.repo.StaffRepo;

@Service
public class StaffServiceImpl implements StaffService {

	private final static Logger logger = LoggerFactory.getLogger( StaffServiceImpl.class );
	
	@Autowired
	private StaffRepo repo;
	
	@Override
	public List<Staff> getAll() throws ServiceException {
		logger.info("In getAll");
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
