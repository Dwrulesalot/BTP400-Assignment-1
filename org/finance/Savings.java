package org.finance;

/**
 * Specific type of account that has an extra variable that accounts for an annual interest rate
 * 
 * @author Jonathan De Groot
 *
 */

public class Savings extends Account
{
	private double interestRate; 

	/**
	 * Three arguement Constructor that calls to account's three arguement constructor
	 * 
	 * @param fN full name of account holder
	 * @param aN account number - will be unique
	 * @param sB starting balance of account - the amount that account was opened with
	 * @param iR interest rate - rate at which the account will increase by yearly
	 * @see Account three arguement constructor
	 */
	public Savings(String fN, String aN, String sB, double iR)
	{
		super(fN, aN, sB);
		interestRate = iR;
	}

	/**
	 * Zero arguement Constructor that calls to the Account's zero arguement constructor
	 */
	public Savings()
	{
		super();
		interestRate = 3.0f;
	}

	/* 
	 * Equals operator checks to see if the 
	 * @param acc object that is being to see it is of type savings of account
	 */
	public boolean equals(Object acc)
 	{
		boolean result = false;
		
		if ( acc instanceof Savings )
		{
			Savings acc2 = (Savings) acc;

			if ( (acc2.fullName.equals(fullName)) &&
					(acc2.accountNum.equals(accountNum)) &&
					(acc2.accountBalance.equals(accountBalance)) &&
					(acc2.interestRate == interestRate))

		result = true;
		}

		return result;
 	}

	/* 
	 * Returns a string containing all the information contained in the saving's account, calling it's parent's toString before appending the extra information to it
	 * @see Account's toString
	 */
	public String toString()
	{
		StringBuffer str = new StringBuffer(super.toString());
		str.append("type: SAVINGS" + "\n" + "annual interest rate: " + interestRate + "%");
	
		String str2 = new String(str); 
		return str2;
	}
}
