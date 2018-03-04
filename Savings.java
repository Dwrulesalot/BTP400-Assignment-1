/**
 * @author Jonathan De Groot
 *
 */

public class Savings extends Account
{
  private double interestRate; //Annual interest rate of savings account

  //3-arg constructor
  /**
 * @param fN
 * @param aN
 * @param sB
 * @param iR
 */
public Savings(String fN, String aN, String sB, double iR)
  {
    super(fN, aN, sB); //call to Account 3-arg constructor
    interestRate = iR;
  }

  //0-arg constructor
  /**
 * 
 */
public Savings()
  {
    super(); //call to Account 0-arg constructor
    interestRate = 0.3f;
  }

  //Equals operator
  /* (non-Javadoc)
 * @see Account#equals(java.lang.Object)
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

  //toString IMMA DO THIS LATER
  /* (non-Javadoc)
 * @see Account#toString()
 */
public String toString()
  {
    super.toString();
    String superCoolString;
    superCoolString = "type: SAVINGS" + "\n" + "annual interest rate: " + interestRate + "%";
    return superCoolString;
  }
}
