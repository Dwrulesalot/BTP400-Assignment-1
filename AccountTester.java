public class AccountTester{
	public static void main(String[] args) {
		
		Account[] accountArray = new Account[7];
		
		accountArray[0] = new Account("Peter Liu", "A12345", 5000);	
		accountArray[1] = new Account("Peter Liu", "A67890", 6000);	
		accountArray[2] = new Account("Abraham Lincoln", "Z6789", 7777);	
		accountArray[3] = new Account("Peter Liu", "A12345", 5000);	
		accountArray[4] = new Account("Daniel Wierzbicki", "E3333", 9000);	
		accountArray[5] = new Account("Abraham Lincoln", "Z6789", 7777);	
		accountArray[6] = new Account("Abraham Lincoln", "Z6789", 7777);	
		
		System.out.println("\n\n\nSUMMARY\n");
		System.out.println("+ total number of accounts: "+ accountArray.length);
		
		boolean[] duplicateArrayIndex = new boolean[accountArray.length];
		duplicateArrayIndex[0] = false;
		
		int printIndex = 1;
		for(int i = 0; i < accountArray.length; i++){
			if(duplicateArrayIndex[i]){
				continue;//continue skips to the end of the loop if duplicate is found
			}
			int duplicate = 1;//there will always be one of each account object if it's being looped through
				
			for(int j = i+1; j <accountArray.length; j++){
				if(accountArray[j].equals(accountArray[i])){
					duplicate++;
					duplicateArrayIndex[j] = true;
				}
			} 
		System.out.println(printIndex + ". " + accountArray[i] + " : " + duplicate);
		printIndex++;
		}
		
		
	}
}