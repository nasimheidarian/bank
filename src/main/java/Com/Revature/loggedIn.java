package Com.Revature;

import java.util.List;
import java.util.Scanner;
import Com.Revature.Models.Client;
import Com.Revature.Models.Account;
import Com.Revature.Models.Operation;
import Com.Revature.services.ClientServices;
import Com.Revature.services.AccountServices;
import Com.Revature.services.OperationServices;

public class loggedIn {
	

		
		private static Scanner sc = new Scanner(System.in);
		
		public void loggedInView(Client legalclnt) {
			
			boolean stayLoggedIn = true;
			
			ClientServices cs = new ClientServices();
			AccountServices ac = new AccountServices();
		    OperationServices os = new OperationServices(); 
		    
		    Client c = cs.getClientById(legalclnt.getId());
		    Account a= ac.getAccountById(c.getId());
		    
		    
		    while (stayLoggedIn) {
		    	
		    	int success = 0;
		    
		    	System.out.println("> Welcome " + c.getfirstName() + " " + c.getlastName() + ".");
		    
			System.out.println("what would you like to do: enter 1  for deposit, 2 for withdraw, 3 for transfer");
			int o = sc.nextInt();
			switch(o) {
			case 1:
				
				System.out.println(" make a deposit");
				System.out.println(">");
				System.out.println("> Your current balance is: " + a.getbalance());
				
				System.out.print("> Enter amount of deposit: ");
				
				double depositAmount = sc.nextDouble();
				
				// validate here
				
				// deposit amount into account
				success = os.depositAmount(a, depositAmount);
				
				if (success == 1) {
					System.out.println(">");
					System.out.println("> Success. Deposit made to account. PRESS ENTER TO CONTINUE.............................................................");
					System.out.println(">");
					System.out.println(">");
					System.out.println("#----------------------------------------------------------------------------------------------------------------------#");
					sc.nextLine();
				}
				break;
			
			case 2:
				System.out.println("withdrwing");
				
				System.out.println(">");
				System.out.println("> Your current balance is: " + a.getbalance());
				
				System.out.print("> Enter amount to withdraw: ");
				
				double withdrawAmount = sc.nextDouble();
				
				// validate here
				
				// withdraw amount from account
				success = os.withdrawAmount(a, withdrawAmount);
				
				if (success == 1) {
					System.out.println(">");
					System.out.println("> Success. Withdraw made from account. PRESS ENTER TO CONTINUE..........................................................");
					System.out.println(">");
					System.out.println(">");
					System.out.println("#----------------------------------------------------------------------------------------------------------------------#");
					sc.nextLine();
				} else if (success == 3) {
					System.out.println(">");
					System.out.println("> Insufficient funds. PRESS ENTER TO CONTINUE...........................................................................");
					System.out.println(">");
					System.out.println(">");
					System.out.println("#----------------------------------------------------------------------------------------------------------------------#");
					sc.nextLine();
				}
				
				sc.nextLine();

				break;
				
			case 3:
                
				System.out.println("> Which account would you like to make a transfer to:");
				int an= sc.nextInt();
				
				Account account = ac.getAccountById(an);
                System.out.print("> Enter transfer amount : ");
				
				double transferAmount = sc.nextDouble();
				
				// validate here
				
				// deposit amount into account
				success = os.depositAmount(account, transferAmount);
				
				if (success == 1) {
					System.out.println(">");
					System.out.println("> Success. transfer made to account. PRESS ENTER TO CONTINUE.............................................................");
					System.out.println(">");
					System.out.println(">");
					System.out.println("#----------------------------------------------------------------------------------------------------------------------#");
					sc.nextLine();
				}
                  break; 
                   
			}
			
		
			
		//}
}
		}
		}
		
			
				
			
		


	



