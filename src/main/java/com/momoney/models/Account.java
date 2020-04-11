package com.momoney.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long accountId;
	
	@NotBlank
	@Column(name = "account_type")
	private String accountType;
	
	@NotBlank
	@Positive
	@Column(name = "balance")
	private Double balance;
	
	@NotBlank
	@Column(name = "account_number", unique = true)
	private Long accountNumber;
	
	@NotBlank
	@Column(name = "routing_number")
	private Long routingNumber;
	
	@NotBlank
	@Positive
	@Column(name = "interest_rate")
	private Double interestRate;
	
	@OneToOne
	private Autosave autosave;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(Long routingNumber) {
		this.routingNumber = routingNumber;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Autosave getAutosave() {
		return autosave;
	}

	public void setAutosave(Autosave autosave) {
		this.autosave = autosave;
	}

	public Account(Long accountId, @NotBlank String accountType, @NotBlank @Positive Double balance,
			@NotBlank Long accountNumber, @NotBlank Long routingNumber, @NotBlank @Positive Double interestRate,
			Autosave autosave) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.interestRate = interestRate;
		this.autosave = autosave;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}