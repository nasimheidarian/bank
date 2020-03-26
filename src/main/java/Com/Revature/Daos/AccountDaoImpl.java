package Com.Revature.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Com.Revature.Models.Account;
import Com.Revature.Models.Client;
import Com.Revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {
	private ClientDao cd = new ClientDaoImpl();

	@Override
	public List<Account> getAccount(int clientid){
		List<Account> Account = new ArrayList<>();
		String sql = "select * from {oj account left outer join "
				+ "client on (account.clientid = client.clientid)}";
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement ps = c.createStatement();
				ResultSet rs = ps.executeQuery(sql)){
		
			while(rs.next()) {
				// get data from each account
				Account a = new Account();
				a.setId(rs.getInt("accountid"));
				a.setbalance(rs.getDouble("balance"));
				
				int clntId = rs.getInt("clientid");
				if(clntId!=0) {
					Client cl = new Client(clntId);
					cl.setfirstName(rs.getString("firstname"));
					cl.setlastName(rs.getString("lastname"));
					a.setclient(cl);
				}
			 Account.add(a);
}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Account;
	
	}

	@Override
	public Account getAccountById(int id) {
	
String sql = "select * from account where accountid = ?";
		
		Account account = null;
		ResultSet rs = null;
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				account = new Account();
				account.setId(id);
				account.setbalance(rs.getDouble("balance"));
				account.setclient(new Client(rs.getInt("clientid")));
			}
			
			Client accountclnt = cd.getClientById(account.getclient().getId());
			account.setclient(accountclnt);
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
		
		return account;
		
	}

	@Override
	public int createAccount(Account a) {
		String sql = "insert into account (balance) values (?)";
		int accountCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
		
			ps.setDouble(1, a.getbalance());
			
			accountCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountCreated;
	}


	@Override
	public int updateAccount(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account createAccountWithFunction(Account a) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}
