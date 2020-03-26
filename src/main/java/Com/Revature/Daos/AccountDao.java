package Com.Revature.Daos;

import java.util.List;

import Com.Revature.Models.Account;

public interface AccountDao {
	public List<Account> getAccount(int clientid);
	public Account getAccountById(int id);
	public int createAccount(Account a);
	public int updateAccount(Account a);
	public Account createAccountWithFunction(Account a);


}
