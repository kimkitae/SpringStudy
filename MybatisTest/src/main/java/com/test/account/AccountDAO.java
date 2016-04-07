package com.test.account;

import java.util.ArrayList;

public interface AccountDAO {

	public ArrayList<Account> getAccounts();

	public void insertAccount(Account account);

	public void updateAccount(Account account);

	public void deleteAccount(String id);

	public void dropTable();


	public ArrayList<Account> selectAccount(String id);

}
