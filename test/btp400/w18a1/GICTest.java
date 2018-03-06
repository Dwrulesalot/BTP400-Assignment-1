package test.btp400.w18a1;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.finance.Account;
import org.finance.GIC;
import org.junit.Test;

public class GICTest {

	@Test //testing if safe state is properly created
	public void test() {
		Account test = new GIC();
		
		Account tester = new GIC("", "", BigDecimal(0), 1, 1.25);
		
		assertEquals(tester, test);
	}
	
	@Test //testing if deposit returns false
	public void test2() {
		Account tester2 = new GIC();
		
		boolean test2 = tester2.deposit("10000");
		
		assertFalse(test2);
	}
	
	@Test //testing if withdraw returns false
	public void test3() {
		Account tester3 = new GIC();
		
		boolean test3 = tester3.withdraw("10000");
		
		assertFalse(test3);
	}
	
	@Test //tests method balanceAtMaturity 
	public void test4() {
		Account tester4 = new GIC("", "", BigDecimal(5000), 1, 1.25);
		
		//answer for above tester should be as below
		BigDecimal test4 = BigDecimal(16420.47);
		
		assertEquals(tester4.balanceAtMaturity(), test4);
	}
	
}
