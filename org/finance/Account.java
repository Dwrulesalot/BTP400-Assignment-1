package org.finance;

import java.math.BigDecimal;
/**
 * @author Daniel Wierzbicki
 *
 */

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
	/**
	 * @param name full name of client
	 * @param aNum account number
	 * @param aBalance account balance / current balance
	 */
	public Account(String name, String aNum, String aBalance) {//example uses double but instructions say to use int

		//checks each entered value, if null or -1 is entered, enters that variable into "safe state"

		if(name==null) {fullName = "";}
		else {fullName = name;}

		if(aNum==null) {accountNum = "";}
		else {accountNum = aNum;}

		if(aBalance.equals("-1") || aBalance == null) {aBalance.equals("0");}
		else {accountBalance = new BigDecimal(aBalance); startingBalance = new BigDecimal(aBalance);}
		
		

	}

	//SETTERS

	//Setter for fullName
	/**
	 * @param name full name
	 */
	public void setFullName(String name) {
		fullName = name;
	}

	//Setter for accountNum
	/**
	 * @param num account number
	 */
	public void setAccountNumber(String num) {
		accountNum = num;
	}

	//Setter for accountBalance
	/**
	 * @param balance
	 */
	public void setAccountBalance(BigDecimal balance) {
		accountBalance = balance;
	}

	//GETTERS

	//Getter for fullName
	/**
	 * @return
	 */
	public String getFullName() {
		return fullName;
	}

	//Getter for accountNum
	/**
	 * @return
	 */
	public String getAccountNumber() {
		return accountNum;
	}

	//Getter for accountBalance
	/**
	 * @return
	 */
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	// the equals() method
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
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
	/**
	 * @param amount
	 * @return
	 */
	public boolean deposit( BigDecimal amount ){
		if(amount.doubleValue() > 0){
			accountBalance = accountBalance.add(amount);
			return true;
		}
		return false;
	}

	/**
	 * @param amount
	 * @return
	 */
	public boolean withdraw( BigDecimal amount ){
		if(amount.intValue() > 0 && (accountBalance.subtract(amount)).intValue() > 0){
			accountBalance = accountBalance.subtract(amount);
			return true;
		}
		return false;
	}

	//toString - to be edited?
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String superCoolString = "number: " + accountNum + ", " + "name: " + fullName + "\n"
		+ "starting balance: " + "$" + startingBalance + ", " + "current balance: " + "$" + accountBalance + "\n";
		return superCoolString;
	}

}
