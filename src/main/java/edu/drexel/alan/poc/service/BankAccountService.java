package edu.drexel.alan.poc.service;

import java.util.List;

import edu.drexel.alan.poc.model.BankAccount;

public interface BankAccountService {
	public List<BankAccount> getAll() throws ServiceException;
	public BankAccount findByID(int id) throws ServiceException;
	public int insert(BankAccount bankAccount) throws ServiceException;
	public int update(BankAccount bankAccount) throws ServiceException;
	public int delete(int id) throws ServiceException;
	public int[] transfer(float amount, int accountFrom, int accountTo) throws ServiceException;
	public int insertList(List<BankAccount> accountList) throws ServiceException;
}
