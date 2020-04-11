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
	private Account account;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Long getJoinId() {
		return joinId;
	}

	public void setJoinId(Long joinId) {
		this.joinId = joinId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserAccount [joinId=" + joinId + ", account=" + account + ", user=" + user + "]";
	}

	public UserAccount(Long joinId, Account account, User user) {
		super();
		this.joinId = joinId;
		this.account = account;
		this.user = user;
	}

	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}