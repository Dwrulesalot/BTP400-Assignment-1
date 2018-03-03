import java.time.LocalDateTime;// not sure if .LocalDateTime is needed of just use java.time
public class BankingApp{
	public static void main(String[] args) {
		
		String menuChoice= "";
		
		Scanner scanner = new Scanner (System.in);//reads user input
		
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
			
			menuChoice=Scanner.next();//reads in user input
			
			if(menuChoice.equals("1")){
				System.out.println("Please enter information(e.g. account type, name, account number, balance, interest rate)");//to read this in we need to use delimiters: Commas followed by zero or more blank spaces are used to separate data values
			}
			else if(menuChoice.equals("2")){
				System.out.println();
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