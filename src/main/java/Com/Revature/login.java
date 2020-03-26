package Com.Revature;

import java.util.Scanner;
import Com.Revature.Models.Client;
import Com.Revature.Models.Account;
import Com.Revature.services.ClientServices;
import Com.Revature.services.AccountServices;

public class login {
	

private static Scanner sc = new Scanner(System.in);	
	
	public void logIntoAccount() {
		
		ClientServices cService = new ClientServices();
		
		System.out.println(">");
		System.out.println("> Loging into your account..............................................................................................");
		System.out.println(">");
		System.out.println("enter username");
 		String userInput = sc.nextLine();
 		System.out.println("enter password");
 		String passInput = sc.nextLine();
 		Client legalclnt = cService.getClientByUserNameAndPassword(userInput,passInput);
		System.out.println(legalclnt);
		
		loggedIn li = new loggedIn();
		li.loggedInView(legalclnt);	
		
}

	}




