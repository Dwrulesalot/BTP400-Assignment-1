//Author: Jonathan De Groot

public class Savings extends Account
{
  private float interestRate; //Annual interest rate of savings account

  //3-arg constructor
  public Savings(fN, aN, sB, iR)
  {
    super(fN, aN, sB); //call to Account 3-arg constructor
    interestRate = iR;
  }

  //0-arg constructor
  public Savings()
  {
    super(); //call to Account 0-arg constructor
    intrestRate = 0.3f;
  }

  //Equals operator
  public equals(Object acc)
  {
    boolean result = false;

    if ( acc instanceof Account )
    {
      Account acc2 = (Account) acc;

      if ( (acc2.fullName.equals(fullName)) &&
           (acc2.accountNum.equals(accountNum)) &&
           (acc2.accountBalance.equals(accountBalance)) &&
           (acc2.interestRate.equals(interestRate)))

           result = true;
    }

    return result;
  }

  //toString IMMA DO THIS LATER
  public toString()
  {
    super.toString();
  }
}
