package Com.Revature.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Com.Revature.Models.Client;
import Com.Revature.util.ConnectionUtil;

public class ClientDaoImpl implements ClientDao {
	



	public List<Client> getClient() {
		List<Client> Client = new ArrayList<>();
		String sql = "select * from  client";
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement ps = c.createStatement();
				ResultSet rs = ps.executeQuery(sql)){
			while(rs.next()) {
				// get data from each Client
				Client cl = new Client();
				cl.setId(rs.getInt("clientid"));
				cl.setfirstName(rs.getString("firstname"));
				cl.setlastName(rs.getString("lastname"));
				cl.setemail(rs.getString("email"));
				cl.setusername(rs.getString("username"));
				cl.setpassword(rs.getString("password"));
			
				Client.add(cl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Client;
	}
		

	@Override
	public Client getClientById(int id) {
String sql = "select * from client where clientid = ?";
		
		Client client = null;
		ResultSet rs = null;
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1 , id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				client = new Client();
				client.setId(id);
				client.setfirstName(rs.getString("firstname"));
				client.setlastName(rs.getString("lastname"));
				client.setemail(rs.getString("email"));
				client.setusername(rs.getString("username"));
				client.setpassword(rs.getString("password"));
				
			}
	
		
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
		
				return client;

			}
	@Override
	public Client getClientByUserNameAndPassword(String username, String password) {
		
			 Client client = new Client();
			 
			 String sql ="SELECT * FROM client WHERE username = ? AND password = ? ";
				
			 ResultSet rs = null;
				
					 try {
						 Connection c = ConnectionUtil.getConnection();
					        PreparedStatement ps = c.prepareStatement(sql);
					        ps.setString(1, username);
					        ps.setString(2, password);
					        
					        ps.execute();
					        
					        rs = ps.getResultSet();
					        
					        while (rs.next()) {
					        	
				                client.setId(rs.getInt("clientid"));
								client.setfirstName(rs.getString("firstname"));
								client.setlastName(rs.getString("lastname"));
								client.setemail(rs.getString("email"));
								client.setusername(username);
								client.setpassword(password);
					        }
							
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							if (rs != null) {
								try {
									rs.close();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}
						
						return client;
					}

	        
	       
	
	

	@Override
	public int createClient(Client cl) {
		
		String sql = "insert into client (firstname,lastname,email,username,password) values (?, ?, ?, ?, ?)";
		int clientCreated = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, cl.getfirstName());
			ps.setString(2, cl.getlastName());
			ps.setString(3, cl.getemail());
			ps.setString(4, cl.getusername());
			ps.setString(5, cl.getpassword());
			
			
			clientCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clientCreated;
	
	}


	@Override
	public int updateClient(Client c) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Client createClientWithFunction(String firstname,String lastname,String email,String username, String password) {
		String sql = "insert into client (firstname,lastname,email,username,password) values (?, ?, ?, ?,?)";
		
	
		Client cl = null;
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			 cl = new Client();
			ps.setString(1,firstname);
			ps.setString(2,lastname);
			ps.setString(3,email);
			ps.setString(4,username);
			ps.setString(5,password);
			
		}
	        catch (SQLException e) {
				e.printStackTrace();
			}
		return cl; 
	}
	


	@Override
	public int deleteClient(Client c) {
		// TODO Auto-generated method stub
		return 0;
	}


					



	
	
}