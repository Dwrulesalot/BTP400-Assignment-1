import java.util.ArrayList;

/**
 * @author Daniel Wierzbicki
 *
 */

public class Bank{
	//ArrayList of accounts
	private String bankName;
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	//Zero Argument Constructor
	/**
	 * 
	 */
	public Bank() {
		bankName ="Seneca@York";
	}
	
	//One Argument Constructor
	/**
	 * @param s
	 */
	public Bank(String s) {
		bankName =s;
	}
	
	/**
	 * @param newAccount
	 * @return
	 */
	public boolean addAccount( Account newAccount ){
		if(newAccount == null){
			return false;
		}
		
		
		for(int i=0; i<accounts.size();i++){
			//if (accounts.get(i).equals(newAccount)){//only works if everything equals the same value looking at the example he wants you to only check account # //note from lab 3
			if (accounts.get(i).getAccountNumber().equals(newAccount.getAccountNumber())){ 
				return false;
			}
		}
		accounts.add(newAccount);
		return true;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals( Object bnk ) {

		boolean result = false;
		
		if ( bnk instanceof Bank ) {

			Bank bnk2 = (Bank) bnk;
			
			for (int i=0;i<accounts.size();i++){
				if (bnk2.bankName.equals(bankName) && bnk2.accounts.equals(accounts)) {
					result = true;
				}
			}
		}
		return result;
	}
	
	/**
	 * @param balance
	 * @return
	 */
	public Account[] searchByBalance(String balance){
		
		int isItEmpty=0;
		
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getAccountBalance().toString().equals(balance)){
				isItEmpty++;
			}
		}
		
		Account[] returnMe = new Account[isItEmpty];
		
		if(isItEmpty==0){
			return returnMe;
		}
		
		int index=0;
		
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getAccountBalance().toString().equals(balance)){
				returnMe[index]=accounts.get(i);
				index++;
			}
		}
		
		return returnMe;
		
	}
	
	//Three new public methods
	/**
	 * @param accountName
	 * @return
	 */
	public Account [ ] searchByAccountName( String accountName ){
		int isItEmpty=0;
		
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getFullName().equals(accountName)){
				isItEmpty++;
			}
		}
		
		Account[] returnMe = new Account[isItEmpty];
		
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
	
	/**
	 * @param accountNumber
	 * @return
	 */
	public Account searchByAccountNumber( String accountNumber ){
		if(!accountNumber.equals("") && !accountNumber.equals(null)){
			for(int i=0;i<accounts.size();i++){
				if(accounts.get(i).getAccountNumber().equals(accountNumber)){
					return accounts.get(i);
				}
			}
		}
		return null;
	}
	
	/**
	 * @param accountNumber
	 * @return
	 */
	public Account removeAccount( String accountNumber ){
		if(!accountNumber.equals("") && !accountNumber.equals(null)){
			for(int i=0;i<accounts.size();i++){
				if(accounts.get(i).getAccountNumber().equals(accountNumber)){
					Account temp;
					temp = accounts.get(i);
					accounts.remove(i);
					return temp; 
				}
			}
		}
		return null;
	}
	
	
	//toString Method
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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