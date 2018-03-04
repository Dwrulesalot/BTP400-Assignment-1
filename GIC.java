//Author Jonathan De Groot

public class GIC extends Account
{
  private int periodOfInvestment;
  private float interestRate;

  //3-arg constructor
  public GIC(String fN, String aN, BigDecimal sB, int pOI, float iR)//Daniel: Added variable types
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
  public boolean deposit(BigDecimal amount){// No transactions can be made on a GIC account
		return false;
  }

  //Withdrawal
  public boolean withdraw(BigDecimal amount){// No transactions can be made on a GIC account
		return false;
    }

	public BigDecimal getBalanceAtMaturity(){
		BigDecimal futureBalance;
		futureBalance = pow((getAccountBalance()*(1+interestRate)), periodOfInvestment);//pow returns a double and also expects a double, will this work? do I need to cast?

		return futureBalance;

	}

	//Equals operator
	public equals(Object acc){
    boolean result = false;

    if ( acc instanceof Account ){
		Account acc2 = (Account) acc;

		if ( (acc2.fullName.equals(fullName)) &&
			(acc2.accountNum.equals(accountNum)) &&
			(acc2.accountBalance.equals(accountBalance)) &&
			(acc2.periodOfInvestment==serviceCharge) &&
			(acc2.interestRate==transactions)

			result = true;
    }
    return result;
  }

  //toString
  public String toString()
  {
    super.toString();
    String superCoolString = "type: GIC" + "annual interest rate: " + interestRate + "%" + "\n" +
    "period of investment" + periodOfInvestment " years" + "\n" +
    "new balance at maturity: " + "$" + getBalanceAtMaturity();
    return superCoolString;
  }

}
