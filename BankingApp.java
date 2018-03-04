import java.time.LocalDateTime;// not sure if .LocalDateTime is needed of just use java.time
import java.lang.String;//lets us use str.split(","); and toLowerCase and .strip()
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Daniel Wierzbicki
 *
 */
public class BankingApp{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String menuChoice= "";
		
		Scanner scanner = new Scanner (System.in);//reads user input
		
		Bank yeet = new Bank("Jonathan & Daniel");//YEET
		
		loadBank(yeet);//populates the bank
		
		while (!menuChoice.equals("6")){
			
			displayMenu("Jonathan & Daniel");
			
			menuChoice = scanner.next();//reads in next user input
			
			if(menuChoice.equals("1")){//am I doing this right?
				
				System.out.println("Please enter information(e.g. account type, name, account number, balance, interest rate): ");
				String input = scanner.next();// reads in rest of the line
				
				//String[] info = input.split(",");//Delimits by , but strings might have a blank space between them, get rid of that later
				
				//if(info[0].toLowerCase().trim().equals("sav") || info[0].toLowerCase().trim().equals("savings") || info[0].trim().toLowerCase().equals("saving") ){//Will open Savings account strip() strips leading and tailing spaces
				if(input.toLowerCase().trim().equals("sav") || input.toLowerCase().trim().equals("savings") || input.toLowerCase().trim().equals("saving") || input.toLowerCase().trim().equals("sav") || input.toLowerCase().trim().equals("savings") || input.toLowerCase().trim().equals("saving")){//Will open Savings account strip() strips leading and tailing spaces
					input = scanner.nextLine();
					String[] info = input.split(",");//Delimits by , but strings might have a blank space between them, get rid of that later
					
					
					if(info.length==4){//checks if correct amount of info was inputed
						Account newAccount = new Savings(info[0].trim(), info[1].trim(), info[2].trim(), Double.valueOf(info[3].trim()));
						yeet.addAccount(newAccount);//not sure is i need the yeet.addAccount or if I just use addAccount
						
						System.out.println("\n+ Account Opened:");
						displayAccount(newAccount);//need to code toString to print out like the example
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// This error means not enough/too many things were inputted for this account
					}
				}
				else if(input.toLowerCase().trim().equals("gic") || input.toLowerCase().trim().equals("guaranteed investment certificate") || input.toLowerCase().trim().equals("gic,") || input.toLowerCase().trim().equals("guaranteed investment certificate,")){//Will open GIC account
					input = scanner.nextLine();
					String[] info = input.split(",");//Delimits by , but strings might have a blank space between them, get rid of that later
					
					
					if(info.length==5){//checks if correct amount of info was inputed
						Account newAccount = new GIC(info[0].trim(), info[1].trim(), info[2].trim(),  Double.valueOf(info[3].trim()),  Double.valueOf(info[4].trim()));// name newAccount can be reused as there's no way the if statements could both be run since it's an else if
						yeet.addAccount(newAccount);//not sure is i need the yeet.addAccount or if I just use addAccount
						
						System.out.println("\n+ Account Opened:");
						displayAccount(newAccount);//need to code toString to print out like the example
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// This error means not enough/too many things were inputted for this account
					}
				}
				else if(input.toLowerCase().trim().equals("cheq") || input.toLowerCase().trim().equals("cheque") || input.toLowerCase().trim().equals("chequing") || input.toLowerCase().trim().equals("cheq,") || input.toLowerCase().trim().equals("cheque,") || input.toLowerCase().trim().equals("chequing,")){//Will open Chequing account
					input = scanner.nextLine();
					String[] info = input.split(",");//Delimits by , but strings might have a blank space between them, get rid of that later
					
					
					if(info.length==4){//checks if correct amount of info was inputed
						Account newAccount = new Chequing(info[0].trim(), info[1].trim(), info[2].trim(), Double.valueOf(info[3].trim()));
						yeet.addAccount(newAccount);//not sure is i need the yeet.addAccount or if I just use addAccount yeet.addAccount(newAccount);//not sure is i need the yeet.addAccount or if I just use addAccount
						
						System.out.println("\n+ Account Opened:");
						displayAccount(newAccount);//need to code toString to print out like the example
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// This error means not enough/too many things were inputted for this account
					}
				}
				else{
					System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// basically means improper input and will return user to the main menu
				}
				String errorFixer = scanner.nextLine();//HEY IT ACTUALLY CATCHS THE ERROR LOL, ALSO PLEASE ACTUALLY FIX THIS ERROR
				
			}
			
			
			else if(menuChoice.equals("2")){
				
				System.out.println("Please enter the account number of the account you would like to close: ");//to read this in we need to use delimiters: Commas followed by zero or more blank spaces are used to separate data values or maybe get the whole line?
				String input = scanner.next();// reads in rest of the line
				
				if(yeet.searchByAccountNumber(input.trim())!=null ){//assumes the return null in bank.java works	
					System.out.println("\n+ Account Deleted:");
					displayAccount(yeet.removeAccount(input.trim()));//need to code toString to print out like the example //will this work even if we don't know the type of account it is? - I certainly hope so
					
				}
				else{
					System.out.println("*** FAILED: ACCOUNT CANNOT BE CLOSED! ***\n");// basically means improper input/account number is invalid and will return user to the main menu
				}
			}
			
			
			else if(menuChoice.equals("3")){
				BigDecimal amount;//maybe make amount BigDecimal
				
				System.out.println("a. Deposit Money.");
				System.out.println("b. Withdraw Money.\n");
				
				String input = scanner.next();
				
				if(input.toLowerCase().equals("a")){//maybe add .strip() later if it works
					System.out.println("Please enter the account number of the account you would like to make a deposit to: ");//to read this in we need to use delimiters: Commas followed by zero or more blank spaces are used to separate data values or maybe get the whole line?
					String input2 = scanner.next();// reads in rest of the line
					
					
					if(yeet.searchByAccountNumber(input2.trim())!=null){
						System.out.println("Please enter the amount you would like to deposit: ");//gotta cast input into a BigDecimal for this to work
						amount = new BigDecimal(scanner.next());
						
						if(yeet.searchByAccountNumber(input2.trim()).deposit(amount)){//I'm starting to think I need to be doing this yeet.blah format alot more // ALSO CASTING A STRING TO BIGDECIMAL???? fuck man idk how much of this code will actually work
							System.out.println("\n+ Account Updated:");
							displayAccount(yeet.searchByAccountNumber(input2.trim()));
						}
						else{
							System.out.println("*** FAILED: ACCOUNT CANNOT BE UPDATED! ***\n");//this error means invalid money amount was input aka negative number or not a number
						}
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE UPDATED! ***\n");//account doesn't exist error
					}
					
					
				}
				else if(input.toLowerCase().equals("b")){//maybe add .strip() later if it works
					System.out.println("Please enter the account number of the account you would like to make a withdrawal from: ");//to read this in we need to use delimiters: Commas followed by zero or more blank spaces are used to separate data values or maybe get the whole line?
					String input2 = scanner.next();// reads in rest of the line
									
					if(yeet.searchByAccountNumber(input2.trim())!=null){
						System.out.println("Please enter the amount you would like to withdraw: ");//gotta cast input into a BigDecimal for this to work
						amount = new BigDecimal(scanner.next());
						
						if(yeet.searchByAccountNumber(input2.trim()).withdraw((BigDecimal)amount)){//I'm starting to think I need to be doing this yeet.blah format alot more // ALSO CASTING A STRING TO BIGDECIMAL???? fuck man idk how much of this code will actually work
							System.out.println("\n+ Account Updated:");
							displayAccount(yeet.searchByAccountNumber(input2.trim()));
						}
						else{
							System.out.println("*** FAILED: ACCOUNT CANNOT BE UPDATED! ***\n");//this error means invalid money amount was input aka negative number or not a number
						}
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE UPDATED! ***\n");//account doesn't exist error
					}
				}
				else{
					System.out.println("*** FAILED: INVALID INPUT! ***\n");// Will return user to the main menu
				}
			}
			
			
			else if(menuChoice.equals("4")){
				
				System.out.println("a. Search by account balance.");
				System.out.println("b. Search by account name.");
				System.out.println("c. Search by account number.\n");
				
				String input = scanner.next();
				
				if(input.toLowerCase().equals("a")){//maybe add .strip() later if it works
					System.out.println("Please enter the account balance of the accounts you're looking for: ");//to read this in we need to use delimiters: Commas followed by zero or more blank spaces are used to separate data values or maybe get the whole line?
					String input2 = scanner.next();
					
					Account [] accountsToRetrieve = yeet.searchByBalance(input2);//added yeet.
					
					if(accountsToRetrieve!=null){//no idea if this works
						listAccounts(accountsToRetrieve);//new
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE RETREIVED! ***\n");//account doesn't exist error
					}
					
					
				}
				else if(input.toLowerCase().equals("b")){//maybe add .strip() later if it works
					System.out.println("Please enter the account name of the accounts you're looking for: ");//to read this in we need to use delimiters: Commas followed by zero or more blank spaces are used to separate data values or maybe get the whole line?
					String input2 = scanner.next();
					
					Account [] accountsToRetrieve = yeet.searchByAccountName(input2);//added yeet.
					
					if(accountsToRetrieve!=null){//no idea if this works
						listAccounts(accountsToRetrieve);//new
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE RETREIVED! ***\n");//account doesn't exist error
					}
				}
				else if(input.toLowerCase().equals("c")){//maybe add .strip() later if it works
					System.out.println("Please enter the account number of the account you would like to make a withdrawal from: ");//to read this in we need to use delimiters: Commas followed by zero or more blank spaces are used to separate data values or maybe get the whole line?
					String input2 = scanner.next();// reads in rest of the line
							
					if(yeet.searchByAccountNumber(input2.trim())!=null){
						displayAccount(yeet.searchByAccountNumber(input2.trim()));
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE RETREIVED! ***\n");//account doesn't exist error
					}
				}
				else{
					System.out.println("*** FAILED: INVALID INPUT! ***\n");// Will return user to the main menu
				}
				
			}
			
			
			else if(menuChoice.equals("5")){
				System.out.println(yeet);//favourite line, also thank you Java Gods for toString.
			}
			
			
			else if(menuChoice.equals("6")){//might move this goodbye message outside the loop if we will be "break"ing out of the loop
				System.out.println("Thanks For Banking with the Bank of Jonathan & Daniel!");
			}
			
			
			else{
				System.out.println("Invalid Entry, please enter a number from 1 to 6");
			}
			
			
		}
	}
	//I'm very upset
	/**
	 * @param bank
	 */
	public static void loadBank(Bank bank){
		Account newAccount1 = new GIC("John Doe", "D1234", "6000.00", 2, 1.5);
		Account newAccount2 = new Chequing("John Doe", "E5678", "15000.00", 0.75);
		Account newAccount3 = new Savings("John Doe", "F9801", "8000.00", 0.15);
		Account newAccount4 = new GIC("Mary Ryan", "A1234", "15000.00", 4 , 2.5);
		Account newAccount5 = new Chequing("Mary Ryan", "B5678", "15000.00", 0.75);
		Account newAccount6 = new Savings("Mary Ryan", "C9012", "8000.00", 0.15);
		bank.addAccount(newAccount1);
		bank.addAccount(newAccount2);
		bank.addAccount(newAccount3);
		bank.addAccount(newAccount4);
		bank.addAccount(newAccount5);
		bank.addAccount(newAccount6);
	}
	//I hate everything
	/**
	 * @param bankName
	 */
	public static void displayMenu( String bankName ){
		System.out.println("\n### Welcome to the Bank of "+bankName+" ###");
		//System.out.println(getHour()+":"+getMinute()+ ); need to look at api and figure out how to get it in the format shown in example
		
		System.out.println("\n1. Open an account");
		System.out.println("2. Close an account");
		System.out.println("3. Update an account");
		System.out.println("4. Search");
		System.out.println("5. List all accounts");
		System.out.println("6. Exit");
		System.out.println("\nPlease enter your choice: ");
	}
	//Fucking end me //Literally useless
	/**
	 * @param account
	 */
	public static void displayAccount( Account account ){
		System.out.println(account);
	}
	//these last two are fucking pointless they replace like a line of code each wtf
	/**
	 * @param listOfAccounts
	 */
	public static void listAccounts( Account [ ] listOfAccounts){
		for (int i=0; i<listOfAccounts.length; i++){
			System.out.println(listOfAccounts.length);
		}
	}
	
}