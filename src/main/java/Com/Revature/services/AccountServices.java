package Com.Revature.services;
import java.util.List;

import Com.Revature.Daos.AccountDao;
import Com.Revature.Daos.AccountDaoImpl;

import Com.Revature.Models.Account;


public class AccountServices {
	
private AccountDao AccountDao = new AccountDaoImpl();
	
	public List<Account> getAccount(int clientid){
		return AccountDao.getAccount(clientid);
	}

	public Account getAccountById(int id) {
		return AccountDao.getAccountById(id);
	}

 public int updateAccount(Account a) {
	 return AccountDao.updateAccount(a);
 }
 }

