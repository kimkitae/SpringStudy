package com.test.account;

import java.util.ArrayList;

import com.test.word.Member;

public interface AccountMapper {
	ArrayList<Account> getAccounts();

	void insertAccount(Account account);

	void updateAccount(Account account);

	void deleteAccount(String id);

	void dropTable();

	ArrayList<Account> selectAccount(String id);
}
