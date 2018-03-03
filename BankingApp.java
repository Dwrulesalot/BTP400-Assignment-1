import java.time.LocalDateTime;// not sure if .LocalDateTime is needed of just use java.time
import java.lang.String;//lets us use str.split(","); and toLowerCase and .strip()

public class BankingApp{
	public static void main(String[] args) {
		
		String menuChoice= "";
		
		Scanner scanner = new Scanner (System.in);//reads user input
		
		Bank yeet = new Bank("Jonathan & Daniel");//YEET
		
		System.out.println("\n### Welcome to the Bank of Jonathan & Daniel ###");
		//System.out.println(getHour()+":"+getMinute()+ ); need to look at api and figure out how to get it in the format shown in example
			
		
		while (menuChoice!=6){
			
			System.out.println("1. Open an account");
			System.out.println("2. Close an account");
			System.out.println("3. Update an account");
			System.out.println("4. Search");
			System.out.println("5. List all accounts");
			System.out.println("6. Exit");
			System.out.println("\nPlease enter your choice: ");
			
			menuChoice=Scanner.next();//reads in next user input
			
			if(menuChoice.equals("1")){//am I doing this right?
				String input;
				System.out.println("Please enter information(e.g. account type, name, account number, balance, interest rate): ");
				input = Scanner.nextLine();// reads in rest of the line
				
				String[] info = str.split(",");//Delimits by , but strings might have a blank space between them, get rid of that later
				
				if(info[0].toLowerCase.strip().equals("sav") || info[0].toLowerCase.strip().equals("savings") || info[0].strip().toLowerCase.equals("saving") ){//Will open Savings account strip() strips leading and tailing spaces
					if(info.length==5){//checks if correct amount of info was inputed
						account newAccount = new Savings(info[1].strip(), info[2].strip(), info[3].strip(), info[4].strip());
						yeet.addAccount(newAccount);//not sure is i need the yeet.addAccount or if I just use addAccount
						
						System.out.println("\n+ Account Opened:");
						System.out.println(newAccount);//need to code toString to print out like the example
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// This error means not enough/too many things were inputted for this account
					}
				}
				else if(info[0].toLowerCase.strip().equals("gic") || info[0].toLowerCase.strip().equals("guaranteed investment certificate") ){//Will open GIC account
					if(info.length==6){//checks if correct amount of info was inputed
						account newAccount = new GIC(info[1].strip(), info[2].strip(), info[3].strip(), info[4].strip(), info[5].strip());// name newAccount can be reused as there's no way the if statements could both be run since it's an else if
						yeet.addAccount(newAccount);//not sure is i need the yeet.addAccount or if I just use addAccount
						
						System.out.println("\n+ Account Opened:");
						System.out.println(newAccount);//need to code toString to print out like the example
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// This error means not enough/too many things were inputted for this account
					}
				}
				else if(info[0].toLowerCase.strip().equals("cheq") || info[0].toLowerCase.strip().equals("cheque") || info[0].toLowerCase.strip().equals("chequing")){//Will open Chequing account
					if(info.length==5){//checks if correct amount of info was inputed
						account newAccount = new Chequing(info[1].strip(), info[2].strip(), info[3].strip(), info[4].strip());
						yeet.addAccount(newAccount);//not sure is i need the yeet.addAccount or if I just use addAccountyeet.addAccount(newAccount);//not sure is i need the yeet.addAccount or if I just use addAccount
						
						System.out.println("\n+ Account Opened:");
						System.out.println(newAccount);//need to code toString to print out like the example
					}
					else{
						System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// This error means not enough/too many things were inputted for this account
					}
				}
				else{
					System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***\n");// basically means improper input and will return user to the main menu
				}
			}
			
			
			else if(menuChoice.equals("2")){
				String input;
				System.out.println("Please enter the account number of the account you would like to close: ");//to read this in we need to use delimiters: Commas followed by zero or more blank spaces are used to separate data values or maybe get the whole line?
				input = Scanner.nextLine();// reads in rest of the line
				
				if(){
					
				}
				else{
					System.out.println("*** FAILED: ACCOUNT CANNOT BE CLOSED! ***\n");// basically means improper input/account number is invalid and will return user to the main menu
				}
			}
			
			
			else if(menuChoice.equals("3")){
				
			}
			
			
			else if(menuChoice.equals("4")){
				
			}
			
			
			else if(menuChoice.equals("5")){
				
			}
			
			
			else if(menuChoice.equals("6")){//might move this goodbye message outside the loop if we will be "break"ing out of the loop
				System.out.println("");
			}
			
			
			else{
				System.out.println("Invalid Entry, please enter a number from 1 to 6");
			}
			
			
		}
	}
}