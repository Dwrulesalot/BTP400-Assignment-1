import java.time.LocalDateTime;// not sure if .LocalDateTime is needed of just use java.time
public class BankingApp{
	public static void main(String[] args) {
		int menuChoice= 0;
		Scanner scanner = new Scanner (System.in);//reads user input
		while (menuChoice!=6){
			
			System.out.println("\n### Welcome to the Bank of Jonathan & Daniel ###");// might move welcome message and date/time out of menu loop
			//System.out.println(getHour()+":"+getMinute()+ ); need to look at api and figure out how to get it in the format shown in example
			
			System.out.println("1. Open an account");
			System.out.println("2. Close an account");
			System.out.println("3. Update an account");
			System.out.println("4. Search");
			System.out.println("5. List all accounts");
			System.out.println("6. Exit");
			System.out.println("\nPlease enter your choice: ");
			menuChoice=Scanner.next();//reads in user input
			
			if(menuChoice==1){
			}
			
			
			
		}
	}
}