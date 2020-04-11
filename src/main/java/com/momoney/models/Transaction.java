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
	private Account account;

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount
				+ ", transactionType=" + transactionType + ", timestamp=" + timestamp + ", account=" + account + "]";
	}

	public Transaction(Long transactionId, @NotBlank Double transactionAmount, @NotBlank String transactionType,
			String timestamp, Account account) {
		super();
		this.transactionId = transactionId;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.timestamp = timestamp;
		this.account = account;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
	