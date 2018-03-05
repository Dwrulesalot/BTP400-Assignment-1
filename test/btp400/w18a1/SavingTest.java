package test.btp400.w18a1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SavingTest {

	@Test //testing if safe state is properly created
	public void test() {
		
		Account test = new Savings();
		
		Account tester = new Savings("", "", BigDecimal(0), 3.0);
		
		assertEquals(tester, test);
		
	}

}
