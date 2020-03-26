package Com.Revature.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Com.Revature.Models.Account;
import Com.Revature.Models.Operation;
import Com.Revature.Models.Type;
import Com.Revature.util.ConnectionUtil;

public class OperationDaoImpl implements OperationDao {
	private AccountDao ad = new AccountDaoImpl();

	
		
	public List<Operation> getOperation() {
		List<Operation> Operation = new ArrayList<>();
		String sql = "select * from {oj operation left outer join "
				+ "account on (operation.accountid = account.accountid)}";
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement ps = c.createStatement();
				ResultSet rs = ps.executeQuery(sql)){
		
			while(rs.next()) {
				// get data from each account
				Operation o = new Operation();
				o.setId(rs.getInt("operationid"));
				int tpId = rs.getInt("operationtypeid");
				if(tpId!=0) {
					Type t = new Type(tpId);
					t.setId(rs.getInt("operationtypeid"));
				    o.settype(t);
				    
				    int acntId = rs.getInt("accountid");
					if(acntId!=0) {
						Account a = new Account(acntId);
						a.setId(rs.getInt("accountid"));
					o.setaccount(a);
					   
				 o.setamount(rs.getDouble("operationamount"));
				
				
					
				}
			 Operation.add(o);
			 
				}
			}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
		
		return Operation;
	

	}

	@Override
	public Operation getOperationById(int id) {
		

		String sql = "select * from operation where operationid = ?";
		Operation operation = null;
		ResultSet rs = null;
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				operation = new Operation();
				operation.setId(id);
				operation.settype(new Type(rs.getInt("operationtypeid")));
				operation.setaccount(new Account(rs.getInt("accountid")));
				operation.setamount(rs.getDouble("operationamount"));
				
			}
			
	   Account operationacnt = ad.getAccountById(operation.getaccount().getId());
		operation.setaccount(operationacnt);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return operation;

	}

	@Override
	public int createOperation(Operation o) {
		String sql = "insert into operation ( operationtypeid,accountid,operationamount) values (?,? ?)";
		int operationCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			

			ps.setDouble(1, o.getamount());
			
			operationCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return operationCreated;
	
	}

	@Override
	public int updateBalanceOperation(Account a, double newBalance) {
int amountWasUpdated = 0 ;
		
		String sql = "update account set balance = ? where clientid = ?";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setDouble(1, newBalance);
			ps.setInt(2, a.getId());
			
			amountWasUpdated = ps.executeUpdate();
			
			if (amountWasUpdated == 1) {
				a.setbalance(newBalance);
			} else {
				System.out.println("> THERE WAS AN ERROR...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return amountWasUpdated;
		
	}

	
	
	
	}
