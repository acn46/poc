package edu.drexel.alan.poc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.alan.poc.model.BankAccount;

//@Service
public class BankAccountServiceImpl {

	public List<BankAccount> getAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public BankAccount findByID(int id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(BankAccount bankAccount) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int update(BankAccount bankAccount) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int id) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int[] transfer(float amount, int accountFrom, int accountTo) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertList(List<BankAccount> accountList) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
