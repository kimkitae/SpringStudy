package com.test.account;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOService implements AccountDAO {

	@Autowired
	@Resource(name="sqlSession_account")
	private SqlSession sqlSession;

	@Override
	public ArrayList<Account> getAccounts() {
		ArrayList<Account> result = new ArrayList<Account>();
		AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
		// getMember()�� �޼ҵ��� mapper.mxl�� id�� �����ؾ��Ѵ�.
		result = accountMapper.getAccounts();

		return result;
	}

	@Override
	public void insertAccount(Account account) {
		AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
		accountMapper.insertAccount(account);
	}
	
	@Override
	public void dropTable(){
		AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
		accountMapper.dropTable();
		
	}

	@Override
	public void updateAccount(Account account) {
		AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
		accountMapper.updateAccount(account);
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAccount(String id) {
		AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
		accountMapper.deleteAccount(id);
	}

	@Override
	public ArrayList<Account> selectAccount(String id) {
		ArrayList<Account> result = new ArrayList<Account>();
		AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

		result = accountMapper.selectAccount(id);

		return result;

	}
	

	

}
