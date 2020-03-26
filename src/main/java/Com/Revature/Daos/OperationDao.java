package Com.Revature.Daos;

import java.util.List;

import Com.Revature.Models.Account;
import Com.Revature.Models.Operation;

public interface OperationDao {
	public List<Operation> getOperation();
	public Operation getOperationById(int id);
	public int createOperation(Operation o);
	public int updateBalanceOperation(Account a,double newBalance); 



}
