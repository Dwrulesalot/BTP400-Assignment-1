//Author: Jonathan De Groot

public class Chequing extends Account
{
  private float serviceCharge; //Service charges
  private ArrayList<float> transactions = new ArrayList<float>(); //ArrayList to keep track of service charges

  //3-arg constructor
  public Chequing(fN, aN, sB, sC)
  {
    super(fN, aN, sB); //call to Account 3-arg constructor
    serviceCharge = sC;
  }

  //0-arg constructor
  public Chequing()
  {
    super(); //call to Account 0-arg constructor
    serviceCharge = 0.25f;
  }

  //Deposit
  public boolean deposit(BigDecimal amount)
  {
    if(amount > 0)
    {
      accountBalance += amount; //add deposit to balance
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
      accountBalance -= amount; //deduct withdrawl from balance
      accountBalance -= serviceCharge; //charge the service fee
      transactions.add(amount * -1); //record the withdrawal as a negatuve number in the ArrayList
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

  //TODO
  public toString()


}
