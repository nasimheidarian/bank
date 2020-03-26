package Com.Revature;




import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Com.Revature.Models.Client;
import Com.Revature.Models.Account;
import Com.Revature.services.ClientServices;
import Com.Revature.services.AccountServices;
import Com.Revature.util.ConnectionUtil;

public class Driver {
	
	//private static final String Account = null;

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		try {
			Connection c = ConnectionUtil.getConnection();
			String driverName = c.getMetaData().getDriverName();
			System.out.println(driverName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ClientServices cService = new ClientServices();
		boolean keepRunning = true;
		
		while(keepRunning) {
			
			System.out.println("Hello - wellcome"+" please enter 1 for log in, 2 for create user");
			
	     	String entInput = sc.nextLine();
	     
	     	switch(entInput) {
	     	case "1":
	      login ln = new login();
	      ln.logIntoAccount();
	     		
        	break;
        	
	    	case"2":
	    		create cr = new create();
	    		cr.CreateNewAccount();
	     		
	     	}
	    	sc.nextLine();
			
	     	
		keepRunning = false;
		
		sc.nextLine();
			
		
		}
			
 			System.out.println(cService.getAllClient());
			
	}
				}
	

		
	
		
	