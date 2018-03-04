import java.math.BigDecimal;
import java.lang.Math;

//Author Jonathan De Groot
public class GIC extends Account
{
  private double periodOfInvestment;
  private double interestRate;

  //3-arg constructor
  public GIC(String fN, String aN, String sB, double pOI, double iR)
  {
    super(fN, aN, sB); //call to Account 3-arg constructor
    periodOfInvestment = pOI;
    interestRate = iR;
  }

  //0-arg constructor
  public GIC()
  {
    super(); //call to Account 0-arg constructor
    periodOfInvestment = 1;
    interestRate = 0.0125f;//Daniel: not sure if f is needed
  }

  //Deposit
  public boolean deposit(String amount){// No transactions can be made on a GIC account
		return false;
  }

  //Withdrawal
  public boolean withdraw(String amount){// No transactions can be made on a GIC account
		return false;
    }

	public BigDecimal getBalanceAtMaturity(){
		double futureBalance = Math.pow((getAccountBalance().doubleValue()*(1+interestRate)), periodOfInvestment);//pow returns a double and also expects a double, will this work? do I need to cast?
		BigDecimal bd = new BigDecimal(futureBalance);
		return bd;
	}

	//Equals operator
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
  public String toString()
  {
    super.toString();
    String superCoolString = "type: GIC" + "annual interest rate: " + interestRate + "%" + "\n" +
    "period of investment" + periodOfInvestment + " years" + "\n" +
    "new balance at maturity: " + "$" + getBalanceAtMaturity();
    return superCoolString;
  }

}
