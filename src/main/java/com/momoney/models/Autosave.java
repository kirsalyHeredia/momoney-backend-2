package com.momoney.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "autosaves")
public class Autosave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "autosave_id")
	private Long autosaveId;
	
	@NotBlank
	@Positive
	@Column(name = "amount")
	private Double amount;
	
	@NotBlank
	@OneToOne
	@JoinColumn(name = "account_to")
	private Account accountTo;
	
	@NotBlank
	@OneToOne
	@JoinColumn(name = "account_from")
	private Account accountFrom;
	
	@Column(name = "start_date")
	private String startDate;
	
	@NotBlank
	@Column(name = "frequency")
	private String frequency;
	
	@NotBlank
	@Column(name = "status")
	private Boolean status;
	
	@NotBlank
	@Positive
	@Column(name = "autosave_limit")
	private Double autosaveLimit;

	public Long getAutosaveId() {
		return autosaveId;
	}

	public void setAutosaveId(Long autosaveId) {
		this.autosaveId = autosaveId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Account getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(Account accountTo) {
		this.accountTo = accountTo;
	}

	public Account getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(Account accountFrom) {
		this.accountFrom = accountFrom;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Double getAutosaveLimit() {
		return autosaveLimit;
	}

	public void setAutosaveLimit(Double autosaveLimit) {
		this.autosaveLimit = autosaveLimit;
	}

	@Override
	public String toString() {
		return "Autosave [autosaveId=" + autosaveId + ", amount=" + amount + ", accountTo=" + accountTo
				+ ", accountFrom=" + accountFrom + ", startDate=" + startDate + ", frequency=" + frequency + ", status="
				+ status + ", autosaveLimit=" + autosaveLimit + "]";
	}

	public Autosave(Long autosaveId, @NotBlank @Positive Double amount, @NotBlank Account accountTo,
			@NotBlank Account accountFrom, String startDate, @NotBlank String frequency, @NotBlank Boolean status,
			@NotBlank @Positive Double autosaveLimit) {
		super();
		this.autosaveId = autosaveId;
		this.amount = amount;
		this.accountTo = accountTo;
		this.accountFrom = accountFrom;
		this.startDate = startDate;
		this.frequency = frequency;
		this.status = status;
		this.autosaveLimit = autosaveLimit;
	}

	public Autosave() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}