package seneca.btp400.w18;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Scanner;

import org.finance.Account;
import org.finance.Chequing;
import org.finance.GIC;
import org.finance.Savings;

import com.little.bank.Bank;

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
		
		Scanner scanner = new Scanner (System.in);
		
		Bank yeet = new Bank("Jonathan & Daniel");
		
		loadBank(yeet);
		
		while (!menuChoice.equals("6")){
			
			displayMenu("Jonathan & Daniel");
			
			String errorFixer;
			
			menuChoice = scanner.nextLine();
			
			if(menuChoice.equals("1")){
				
				System.out.println("Please enter information(e.g. account type, name, account number, balance, interest rate): ");
				String input = scanner.next();
				
				if(input.toLowerCase().trim().equals("sav") || input.toLowerCase().trim().equals("savings") || input.toLowerCase().trim().equals("saving") || input.toLowerCase().trim().equals("sav,") || input.toLowerCase().trim().equals("savings,") || input.toLowerCase().trim().equals("saving,")){//Will open Savings account strip() strips leading and tailing spaces
					input = scanner.nextLine();
					String[] info = input.split(",");
					
					
					if(info.length==4){
						Account newAccount = new Savings(info[0].trim(), info[1].trim(), info[2].trim(), Double.valueOf(info[3].trim()));
						if(yeet.addAccount(newAccount)){
							
							System.out.println("\n+ Account Opened:");
							displayAccount(newAccount);
						}
						else{
							errorFixer = scanner.nextLine();
							System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// This error means account with the same account ID is trying to be made
						}
					}
					else{
						errorFixer = scanner.nextLine();
						System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// This error means not enough/too many things were inputted for this account
					}
				}
				else if(input.toLowerCase().trim().equals("gic") || input.toLowerCase().trim().equals("guaranteed investment certificate") || input.toLowerCase().trim().equals("gic,") || input.toLowerCase().trim().equals("guaranteed investment certificate,")){//Will open GIC account
					input = scanner.nextLine();
					String[] info = input.split(",");
					
					
					if(info.length==5){
						Account newAccount = new GIC(info[0].trim(), info[1].trim(), info[2].trim(),  Double.valueOf(info[3].trim()),  Double.valueOf(info[4].trim()));// name newAccount can be reused as there's no way the if statements could both be run since it's an else if
						
						if(yeet.addAccount(newAccount)){
							
							System.out.println("\n+ Account Opened:");
							displayAccount(newAccount);
						}
						else{
							errorFixer = scanner.nextLine();
							System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// This error means account with the same account ID is trying to be made
						}
					}
					else{
						errorFixer = scanner.nextLine();
						System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// This error means not enough/too many things were inputted for this account
					}
				}
				else if(input.toLowerCase().trim().equals("cheq") || input.toLowerCase().trim().equals("cheque") || input.toLowerCase().trim().equals("chequing") || input.toLowerCase().trim().equals("cheq,") || input.toLowerCase().trim().equals("cheque,") || input.toLowerCase().trim().equals("chequing,")){//Will open Chequing account
					input = scanner.nextLine();
					String[] info = input.split(",");
					
					
					if(info.length==4){
						Account newAccount = new Chequing(info[0].trim(), info[1].trim(), info[2].trim(), Double.valueOf(info[3].trim()));
						
						if(yeet.addAccount(newAccount)){
							
							System.out.println("\n+ Account Opened:");
							displayAccount(newAccount);
						}
						else{
							errorFixer = scanner.nextLine();
							System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// This error means account with the same account ID is trying to be made
						}
					}
					else{
						errorFixer = scanner.nextLine();
						System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// This error means not enough/too many things were inputted for this account
					}
				}
				else{
					errorFixer = scanner.nextLine();
					System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// basically means improper input and will return user to the main menu
				}
				
			}
			
			
			else if(menuChoice.equals("2")){
				
				System.out.println("Please enter the account number of the account you would like to close: ");
				String input = scanner.nextLine();
				
				if(yeet.searchByAccountNumber(input.trim())!=null ){	
					System.out.println("\n+ Account Deleted:");
					displayAccount(yeet.removeAccount(input.trim()));
					
				}
				else{
					System.out.println("*** FAILED: ACCOUNT CANNOT BE CLOSED! ***\n");// basically means improper input/account number is invalid 
				}
			}
			
			
			else if(menuChoice.equals("3")){
				BigDecimal amount;
				
				System.out.println("a. Deposit Money.");
				System.out.println("b. Withdraw Money.\n");
				
				String input = scanner.nextLine();
				
				if(input.toLowerCase().equals("a")){
					System.out.println("Please enter the account number of the account you would like to make a deposit to: ");
					String input2 = scanner.nextLine();
					
					
					if(yeet.searchByAccountNumber(input2.trim())!=null){
						System.out.println("Please enter the amount you would like to deposit: ");
						amount = new BigDecimal(scanner.nextLine());
						
						if(yeet.searchByAccountNumber(input2.trim()).deposit(amount)){
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
				else if(input.toLowerCase().equals("b")){
					System.out.println("Please enter the account number of the account you would like to make a withdrawal from: ");
					String input2 = scanner.nextLine();
									
					if(yeet.searchByAccountNumber(input2.trim())!=null){
						System.out.println("Please enter the amount you would like to withdraw: ");
						amount = new BigDecimal(scanner.nextLine());
						
						if(yeet.searchByAccountNumber(input2.trim()).withdraw((BigDecimal)amount)){
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
					System.out.println("*** FAILED: INVALID INPUT! ***\n");
				}
			}
			
			
			else if(menuChoice.equals("4")){
				
				System.out.println("a. Search by account balance.");
				System.out.println("b. Search by account name.");
				System.out.println("c. Search by account number.\n");
				
				String input = scanner.nextLine();
				
				if(input.toLowerCase().equals("a")){
					System.out.println("Please enter the account balance of the accounts you're looking for: ");
					String input2 = scanner.nextLine();
					
					Account [] accountsToRetrieve = yeet.searchByBalance(input2);
					
					if(accountsToRetrieve!=null){
						listAccounts(accountsToRetrieve);
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE RETREIVED! ***\n");//account doesn't exist error
					}
					
					
				}
				else if(input.toLowerCase().equals("b")){
					System.out.println("Please enter the account name of the accounts you're looking for: ");
					String input2 = scanner.nextLine();
					
					Account [] accountsToRetrieve = yeet.searchByAccountName(input2);
					
					if(accountsToRetrieve!=null){
						listAccounts(accountsToRetrieve);
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE RETREIVED! ***\n");//account doesn't exist error
					}
				}
				else if(input.toLowerCase().equals("c")){
					System.out.println("Please enter the account number of the account you're looking for: ");
					String input2 = scanner.nextLine();
							
					if(yeet.searchByAccountNumber(input2.trim())!=null){
						displayAccount(yeet.searchByAccountNumber(input2.trim()));
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE RETREIVED! ***\n");//account doesn't exist error
					}
				}
				else{
					System.out.println("*** FAILED: INVALID INPUT! ***\n");
				}
				
			}
			
			
			else if(menuChoice.equals("5")){
				System.out.println(yeet);
			}
			
			
			else if(menuChoice.equals("6")){
				System.out.println("Thanks For Banking with the Bank of Jonathan & Daniel!");
			}
			
			
			else{
				System.out.println("Invalid Entry, please enter a number from 1 to 6");
			}
			
			
		}
	}
	
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
	
	/**
	 * @param bankName
	 */
	public static void displayMenu( String bankName ){
		System.out.println("\n### Welcome to the Bank of "+bankName+" ###");
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("h:mm a, MMMM dd, yyyy")));
		
		System.out.println("\n1. Open an account");
		System.out.println("2. Close an account");
		System.out.println("3. Update an account");
		System.out.println("4. Search");
		System.out.println("5. List all accounts");
		System.out.println("6. Exit");
		System.out.println("\nPlease enter your choice: ");
	}
	
	/**
	 * @param account
	 */
	public static void displayAccount( Account account ){
		System.out.println(account);
	}
	
	/**
	 * @param listOfAccounts
	 */
	public static void listAccounts( Account [ ] listOfAccounts){
		for (int i=0; i<listOfAccounts.length; i++){
			System.out.println(listOfAccounts[i] + "\n");
		}
	}
	
}