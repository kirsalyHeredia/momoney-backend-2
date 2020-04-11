package com.momoney.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Long transactionId;
	
	@NotBlank
	@Column(name = "transaction_amount")
	private Double transactionAmount;
	
	@NotBlank
	@Column(name = "transaction_type")
	private String transactionType;
	
	@Column(name = "timestamp")
	private String timestamp;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Long accountId;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Transaction(Long transactionId, @NotBlank Double transactionAmount, @NotBlank String transactionType,
			String timestamp, Long accountId) {
		super();
		this.transactionId = transactionId;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.timestamp = timestamp;
		this.accountId = accountId;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}