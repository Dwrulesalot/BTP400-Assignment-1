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

  public boolean withdraw( BigDecimal amount ){
    if(amount>0 && (accountBalance-amount)>0){
      accountBalance-=amount;
      return true;
    }
    return false;
  }

  public boolean deposit(BigDecimal amount)
  {
    if(amount > 0)
    {
      accountBalance += amount; //add deposit to balance
      accountBalance -= serviceCharge; //charge the service fee
      transactions.add(amount); //record the deposit in the ArrayList
      return true;
    }
    else
      return false;
  }

  public boolean withdraw(BigDecimal amount)
  {
    if(amount > 0 && (accountBalance - amount) > 0)
    {
      accountBalance -= amount;
      accountBalance -= serviceCharge;
      transactions.add(amount * -1);
      return true;
    }
    else
      return false;
}
