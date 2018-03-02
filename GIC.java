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
    intrestRate = 0.0125f;//Daniel: not sure if f is needed
  }

}
