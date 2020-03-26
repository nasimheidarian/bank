package Com.Revature;

import java.util.Scanner;
import Com.Revature.Models.Client;
import Com.Revature.Models.Account;
import Com.Revature.services.ClientServices;
import Com.Revature.services.AccountServices;

public class create {
	

private static Scanner sc = new Scanner(System.in);	
	
	public void CreateNewAccount() {
		
		ClientServices cService = new ClientServices();
		
		System.out.println("enter your name");
 	    String nameInput = sc.nextLine();
 		System.out.println("enter your lastname");
 	    String lnameInput = sc.nextLine();
 	   System.out.println("enter your email");
 	    String emailInput = sc.nextLine();
 	   System.out.println("enter your username");
 	    String unamelInput = sc.nextLine();
 	   System.out.println("enter your password");
 	    String paswInput = sc.nextLine();
 	   Client legalclnt = new Client(nameInput,lnameInput,emailInput,unamelInput,paswInput);
 	   System.out.println(cService.createClient(legalclnt));
		
 	  loggedIn li = new loggedIn();
		li.loggedInView(legalclnt);	
		
		
}

	}




