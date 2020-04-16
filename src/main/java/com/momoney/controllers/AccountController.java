package com.momoney.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.momoney.jview.DataView;
import com.momoney.models.Transaction;
import com.momoney.models.UserAccount;
import com.momoney.repos.AccountRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/momoney")
public class AccountController {

	@Autowired
	private AccountRepo accountRepo;
	
	
	// retrieves all of the accounts associated with a single user
	// based on their user-id.
	@GetMapping("/{userId}/accounts")
	@JsonView(DataView.AccountView.class)
	public List<UserAccount> findUserAccounts(@PathVariable(value="userId") Long userId){
		return accountRepo.findAllUserAccounts(userId);
	}
	
	// retrieves all of the transactions associated with a single
	// account based on the acct-id.
	@GetMapping("/account/{accountId}")
	@JsonView(DataView.TransactionView.class)
	public List<Transaction> findAccountTransactions(@PathVariable(value="accountId") Long accountId){
		return accountRepo.findAllUserTransactions(accountId);
	}
}
