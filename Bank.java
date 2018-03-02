import java.util.ArrayList;

public class Bank{
	//ArrayList of accounts
	private String bankName;
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	//Zero Argument Constructor
	public Bank() {
		bankName ="Seneca@York";
	}
	
	//One Argument Constructor
	public Bank(String s) {
		bankName =s;
	}
	
	public boolean addAccount( Account newAccount ){
		if(newAccount == null){
			return false;
		}
		
		
	for(int i=0; i<accounts.size();i++){//could also use .contains
			//if (accounts.get(i).equals(newAccount)){//only works if everything equals the same value looking at the example he wants you to only check account #
			if (accounts.get(i).getAccountNumber().equals(newAccount.getAccountNumber())){ 
				return false;
			}
		}
		accounts.add(newAccount);
		return true;
		
	}
	
	public boolean equals( Object bnk ) {

		boolean result = false;
		
		if ( bnk instanceof Bank ) {

			Bank bnk2 = (Bank) bnk;
			
			for (int i=0;i<accounts.size();i++){
				if (bnk2.bankName.equals(bankName) && bnk2.accounts.equals(accounts)) {//uses built in array-list .equals function
					result = true;
				}
			}
		}
		return result;
	}
	
	public Account[] searchByBalance(int balance){//maybe make it static Account[]?
		
		int isItEmpty=0;
		
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getAccountBalance()== balance){
				isItEmpty++;
			}
		}
		
		Account[] returnMe = new Account[isItEmpty];//supposed to return array with length zero if nothing is found?
		
		if(isItEmpty==0){
			return returnMe;
		}
		
		int index=0;
		
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getAccountBalance()== balance){
				returnMe[index]=accounts.get(i);
				index++;
			}
		}
		
		return returnMe;
		
	}
	
	//Three new public methods
	public Account [ ] searchByAccountName( String accountName ){//just re-used code from above, double check if logic holds
		int isItEmpty=0;
		
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getFullName().equals(accountName)){
				isItEmpty++;
			}
		}
		
		Account[] returnMe = new Account[isItEmpty];//supposed to return array with length zero if nothing is found?
		
		if(isItEmpty==0){
			return returnMe;
		}
		
		int index=0;
		
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getFullName().equals(accountName)){
				returnMe[index]=accounts.get(i);
				index++;
			}
		}
		
		return returnMe;
		
	}
	
	public Account searchByAccountNumber( String accountNumber ){
		if(!accountNumber.equals("") && !accountNumber.equals(null)){
			for(int i=0;i<accounts.size();i++){
				if(accounts.get(i).getAccountNumber().equals(accountNumber)){
					return accounts.get(i); //not sure if I can do this
				}
			}
		}
		return null;
	}
	
	public Account removeAccount( String accountNumber ){//remove an account but also return it? dumb but okay
		if(!accountNumber.equals("") && !accountNumber.equals(null)){
			for(int i=0;i<accounts.size();i++){
				if(accounts.get(i).getAccountNumber().equals(accountNumber)){
					Account temp;
					temp = accounts.get(i);//not sure if I can do this
					accounts.remove(i);
					return temp; 
				}
			}
		}
		return null;
	}
	
	
	//toString Method
	public String toString() {
		String superCoolString;
		superCoolString = "\n\n*** Welcome to the Bank of "+bankName+" ***"+"\nIt has "+accounts.size()+" accounts.";
		for (int i=0; i<accounts.size(); i++){
			int temp = i+1;
			superCoolString+="\n"+temp+". number: "+accounts.get(i).getAccountNumber()+", name: "+accounts.get(i).getFullName()+", balance: $"+accounts.get(i).getAccountBalance();
		}
		return superCoolString;
	}
	
}