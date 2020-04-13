package com.momoney.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.momoney.models.Account;
import com.momoney.models.Transaction;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

	@Query("SELECT o FROM UserAccount o WHERE o.user.userId = :userId")
	List<Account> findAllUserAccounts(@Param("userId") Long userId);
		
	@Query("SELECT o FROM Transaction o WHERE o.account.accountId = :accountId")
	List<Transaction> findAllUserTransactions(@Param("accountId") Long accountId);
	
}
