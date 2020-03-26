package Com.Revature.services;
import java.util.List;

import Com.Revature.Daos.OperationDao;
import Com.Revature.Daos.OperationDaoImpl;

import Com.Revature.Models.Operation;
import Com.Revature.Models.Account;


public class OperationServices {
	
private OperationDao OperationDao = new OperationDaoImpl();
	
	public List<Operation> getAllOperation(){
		return OperationDao.getOperation();
	}

	public Operation getOperationById(int id) {
		return OperationDao.getOperationById(id);
	}

    public boolean CreateOperation() {
		return false;
	  
 }
  
	
	public int depositAmount(Account a, double depositAmount) {
		
		int success = 0;
		
		double newBalance = a.getbalance() + depositAmount;
		
		success = OperationDao.updateBalanceOperation(a, newBalance);
		
		return success;
		// log in transactions
	}
	
	public int withdrawAmount(Account a, double withdrawAmount) {
		
		int success = 0;
		
		double newBalance = a.getbalance() - withdrawAmount;
		
		if (newBalance >= 0) {
			success = OperationDao.updateBalanceOperation(a, newBalance);
		} else {
			success = 3;
		}
		
		// log in transactions
		
		return success;
		
	}

    
}

