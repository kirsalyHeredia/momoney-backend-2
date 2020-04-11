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

@Entity
@Table(name = "user_accounts")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "join_id")
	private Long joinId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Long accountId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Long userId;

	public Long getJoinId() {
		return joinId;
	}

	public void setJoinId(Long joinId) {
		this.joinId = joinId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserAccount(Long joinId, Long accountId, Long userId) {
		super();
		this.joinId = joinId;
		this.accountId = accountId;
		this.userId = userId;
	}

	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}