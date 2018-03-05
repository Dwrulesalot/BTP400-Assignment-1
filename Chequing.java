import java.math.BigDecimal;
import java.util.ArrayList;
/**
 * @author Jonathan De Groot
 *
 */

public class Chequing extends Account
{
  private BigDecimal serviceCharge; //Service charges
  ArrayList<String> transactions = new ArrayList<String>(); //ArrayList to keep track of service charges
  private int totalServiceCharge; //counter for service charges

  //3-arg constructor
  /**
 * @param fN
 * @param aN
 * @param sB
 * @param sC
 */
public Chequing(String fN, String aN, String sB, double sC)
  {
    super(fN, aN, sB); //call to Account 3-arg constructor
    serviceCharge = new BigDecimal(sC);
  }

  //0-arg constructor
  /**
 * 
 */
public Chequing()
  {
    super(); //call to Account 0-arg constructor
    serviceCharge = new BigDecimal(0.25);
  }

  //Deposit
  /* (non-Javadoc)
 * @see Account#deposit(java.math.BigDecimal)
 */
public boolean deposit(BigDecimal amount)
  {
    if(amount.intValue() > 0)
    {
      accountBalance = accountBalance.add(amount); //add deposit to balance 
      transactions.add(amount.toString()); //record the deposit in the ArrayList
      return true;
    }
    else
      return false;
  }

  //Withdrawal
  /* (non-Javadoc)
 * @see Account#withdraw(java.math.BigDecimal)
 */
public boolean withdraw(BigDecimal amount)
  {
    if(amount.intValue() > 0 && (accountBalance.subtract(amount)).intValue() > 0)
    {
      accountBalance = accountBalance.subtract(amount); //deduct withdrawal from balance 
      accountBalance = accountBalance.subtract(serviceCharge); //charge the service fee
      int why = amount.intValue() * -1;
      transactions.add(Integer.toString(why)); //record the withdrawal as a negative number in the ArrayList
      totalServiceCharge++;
      return true;
    }
    else
      return false;
    }

  //Equals operator
  /* (non-Javadoc)
 * @see Account#equals(java.lang.Object)
 */
public boolean equals(Object acc)
  {
    boolean result = false;

    if ( acc instanceof Chequing)
    {
      Chequing acc2 = (Chequing) acc;

      if ( (acc2.fullName.equals(fullName)) &&
           (acc2.accountNum.equals(accountNum)) &&
           (acc2.accountBalance.equals(accountBalance)) &&
           (acc2.serviceCharge.intValue() == serviceCharge.intValue()) &&
           (acc2.transactions.equals(transactions)))

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
    str.append("type: CHEQUING" + "\n"
    + "service charge: " + "$" + serviceCharge + "\n"
    + "number of transactions: " + transactions.size() + "\n"
    + "total amount of service charge: " + "$" + (totalServiceCharge * serviceCharge.doubleValue()));
   
    String str2 = new String(str); 
    return str2;
  }
}
