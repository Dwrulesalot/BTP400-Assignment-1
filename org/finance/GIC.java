package org.finance;

import java.math.BigDecimal;
import java.lang.Math;

/**
 * @author Jonathan De Groot
 *
 */

public class GIC extends Account
{
  private double periodOfInvestment;
  private double interestRate;

  //3-arg constructor
  /**
 * @param fN
 * @param aN
 * @param sB
 * @param pOI
 * @param iR
 */
public GIC(String fN, String aN, String sB, double pOI, double iR)
  {
    super(fN, aN, sB);
    periodOfInvestment = pOI;
    interestRate = iR;
  }

  //0-arg constructor
  /**
 * 
 */
public GIC()
  {
    super(); 
    periodOfInvestment = 1;
    interestRate = 1.25;
  }

  //Deposit
  /**
 * @param amount
 * @return
 */
public boolean deposit(String amount){
		System.out.println("No deposits may be made on a GIC account");
		return false;
  }

  //Withdrawal
  /**
 * @param amount
 * @return
 */
public boolean withdraw(String amount){
		System.out.println("No withdrawals may be made on a GIC account");
		return false;
    }

	/**
	 * @return
	 */
	public BigDecimal getBalanceAtMaturity(){
		double futureBalance = (getAccountBalance().doubleValue()* Math.pow((1 + (interestRate/12)), periodOfInvestment));
		BigDecimal bd = new BigDecimal(futureBalance);
		return bd;
	}

	//Equals operator
	/* (non-Javadoc)
	 * @see Account#equals(java.lang.Object)
	 */
	public boolean equals(Object acc){
    boolean result = false;

    if ( acc instanceof GIC ){
		GIC acc2 = (GIC) acc;

		if ( (acc2.fullName.equals(fullName)) &&
			(acc2.accountNum.equals(accountNum)) &&
			(acc2.accountBalance.equals(accountBalance)) &&
			(acc2.periodOfInvestment == periodOfInvestment &&
			(acc2.interestRate == interestRate)))

			result = true;
    }
    return result;
  }

  //toString
  /* (non-Javadoc)
 * @see Account#toString()
 */
public String toString()
  {
	StringBuffer str = new StringBuffer(super.toString());
    str.append("type: GIC " + "annual interest rate: " + interestRate + "%" + "\n" +
    "period of investment: " + (int)periodOfInvestment + " years" + "\n" +
    "new balance at maturity: " + "$" + getBalanceAtMaturity());
    
    String str2 = new String(str); 
    return str2;
  }

}
