//Author: Jonathan De Groot

public class Chequing extends Account
{
  private float serviceCharge; //Service charges
  private ArrayList<float> = new ArrayList<float>(); //ArrayList to keep track of service charges

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
  //TODO
  public boolean deposit(BigDecimal amount)
  {

  }

  public boolean withdraw(BigDecimal amount)
  {

  }
}
