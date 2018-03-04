import java.math.BigDecimal;
public class Account{

	protected String fullName, accountNum;
	protected BigDecimal accountBalance, startingBalance;


	//Zero Argument Constructor
	public Account() {
		fullName = "";
		accountNum = "";
		accountBalance = new BigDecimal(0);
	}

	//Three Argument Constructor
	public Account(String name, String aNum, String aBalance) {//example uses double but instructions say to use int

		//checks each entered value, if null or -1 is entered, enters that variable into "safe state"

		if(name==null) {fullName = "";}
		else {fullName = name;}

		if(aNum==null) {accountNum = "";}
		else {accountNum = aNum;}

		if(accountBalance.equals("-1")) {accountBalance.equals("0");}
		else {accountBalance = new BigDecimal(aBalance);}

	}

	//SETTERS

	//Setter for fullName
	public void setFullName(String name) {
		fullName = name;
	}

	//Setter for accountNum
	public void setAccountNumber(String num) {
		accountNum = num;
	}

	//Setter for accountBalance
	public void setAccountBalance(BigDecimal balance) {
		accountBalance = balance;
	}

	//GETTERS

	//Getter for fullName
	public String getFullName() {
		return fullName;
	}

	//Getter for accountNum
	public String getAccountNumber() {
		return accountNum;
	}

	//Getter for accountBalance
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	// the equals() method
    public boolean equals( Object acc ) {

		boolean result = false;

		if ( acc instanceof Account ) {

			Account acc2 = (Account) acc;

			if ( (acc2.fullName.equals(fullName)) &&
			     (acc2.accountNum.equals(accountNum)) &&
			     (acc2.accountBalance.equals(accountBalance)))

			     result = true;
		}

		return result;
	}

	//Two new public methods
	public boolean deposit( BigDecimal amount ){
		if(amount.intValue() > 0){
			accountBalance.add(amount);
			return true;
		}
		return false;
	}

	public boolean withdraw( BigDecimal amount ){
		if(amount.intValue() > 0 && (accountBalance.subtract(amount)).intValue() > 0){
			accountBalance.subtract(amount);
			return true;
		}
		return false;
	}

	//toString - to be edited?
	public String toString() {
		String superCoolString;
		superCoolString = "number: " + accountNum + ", " + "name: " + fullName + "\n"
		+ "starting balance: " + "$" + startingBalance + ", " + "current balance: " + "$" + accountBalance + "\n";
		return superCoolString;
	}

}
