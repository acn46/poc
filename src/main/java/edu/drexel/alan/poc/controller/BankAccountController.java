package edu.drexel.alan.poc.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.drexel.alan.poc.model.BankAccount;
import edu.drexel.alan.poc.service.BankAccountService;
import edu.drexel.alan.poc.service.BankAccountServiceImpl;
import edu.drexel.alan.poc.service.ServiceException;

//@RestController
public class BankAccountController {
	
	@Autowired
	private BankAccountService service;
	
	@GetMapping("/banks")
	public List<BankAccount> getAll() {
		System.out.println("\nin getAll");
		List<BankAccount> list = null;
		try {
			list = service.getAll();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@GetMapping("bank/{id}")
	public BankAccount findByID(@PathVariable("id") int id) {
		System.out.println("\nin findByID");
		BankAccount bankAccount = null;
		try {
			bankAccount = service.findByID(id);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("bankAccount = " + bankAccount);
		return bankAccount;
		}

	@PostMapping("/bank/insert")
	public int insert(BankAccount bankAccount) {
		System.out.println("\nin Insert");
		//BankAccount bankAccount = new BankAccount(5, "checking", 13321.22);
		int bankAccountId = 0;
		try {
			bankAccountId = service.insert(bankAccount);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bankAccountId;
	}
	
	@PostMapping("/bank/update")
	public int update(BankAccount bankAccount) {
		System.out.println("\nin update");
		//BankAccount bankAccount = new BankAccount(4, "checking", 10000);
		//bankAccount.setAccountId(5);
		int rowAffected = 0;
		try {
			rowAffected = service.update(bankAccount);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowAffected;
	}
	
	@DeleteMapping("/bank/{id}")
	public int delete(@PathVariable("id") int id) {
		System.out.println("\nin delete");
		int rowAffected = 0;
		try {
			rowAffected = service.delete(id);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowAffected;
	}
	
	//@POST
	public void transfer(float amount, int accountFrom, int accountTo) {
		System.out.println("\ntest transfer");
		int[] rowAffected = null;
		try {
			rowAffected = service.transfer(amount, accountFrom, accountTo);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				System.out.println(rowAffected[0] + ", " + rowAffected[1]);
	}

}
