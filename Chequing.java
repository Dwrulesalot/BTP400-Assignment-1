//Author: Jonathan De Groot

public class Chequing extends Account
{
  private float serviceCharge; //Service charges
  private ArrayList<float> transactions = new ArrayList<float>(); //ArrayList to keep track of service charges
  private int totalServiceCharge; //counter for service charges

  //3-arg constructor
  public Chequing(String fN, String aN, BigDecimal sB, float sC)//Daniel: Added variable types
  {
    super(fN, aN, sB); //call to Account 3-arg constructor
    serviceCharge = sC;
  }

  //0-arg constructor
  public Chequing()
  {
    super(); //call to Account 0-arg constructor
    serviceCharge = 0.25f;//Daniel: don't think f is needed
  }

  //Deposit
  public boolean deposit(BigDecimal amount)
  {
    if(amount > 0)
    {
	accountBalance += amount; //add deposit to balance  //Daniel: could also use the setters created in account rather than making the variables protected then using them here like you did. ie. setAccountBalance(accountBalance+amount)
      transactions.add(amount); //record the deposit in the ArrayList
      return true;
    }
    else
      return false;
  }

  //Withdrawal
  public boolean withdraw(BigDecimal amount)
  {
    if(amount > 0 && (accountBalance - amount) > 0)
    {
      accountBalance -= amount; //deduct withdrawal from balance //Daniel: could also use the setters created in account rather than making the variables protected then using them here like you did.
      accountBalance -= serviceCharge; //charge the service fee
      transactions.add(amount * -1); //record the withdrawal as a negative number in the ArrayList //Daniel: Should serviceCharge be included in amount?
      totalServiceCharge++;
      return true;
    }
    else
      return false;
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
           (acc2.serviceCharge.equals(serviceCharge))) &&
           (acc2.transactions.equals(transactions))

           result = true;
    }
    return result;
  }

  //toString
  public String toString()
  {
    super.toString();
    String superCoolString = "type: CHEQUING" + "\n"
    + "service charge: " + "$" + serviceCharge + "\n"
    + "number of transactions: " + transactions.size() + "\n"
    + "total amount of service charge: " + "$" + (totalServiceCharge * serviceCharge);

    return superCoolString
  }
}
