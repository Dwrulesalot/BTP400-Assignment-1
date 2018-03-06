package test.btp400.w18a1;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.finance.Chequing;
import org.junit.Test;

public class ChequingTest {
/* old version
	@Test
	public void test() {
		//BigDecimal amount = new BigDecimal("200.00");
		Chequing chequing = new Chequing("dude", "dude", "dude", 1000.00);
		chequing.toString();
		//Deposit(amount);
		fail("Not yet implemented");
	}
	*/
	@Test //testing if safe state is properly created
	public void test() {
		Account test = new Chequing();
		
		Account tester = new Chequing("", "", BigDecimal(0), 0.25);
		
		assertEquals(tester, test);
	}
	
	@Test //testing if deposit returns true
	public void depositTest1() {
		Account depositTester1 = new GIC("", "", BigDecimal(10), 0.25);
		
		boolean depositTest1 = depositTester1.deposit(BigDecimal(10));
		
		assertTrue(depositTest1);
	}
	
	@Test //testing if deposit returns false
	public void depositTest2() {
		Account depositTester2 = new GIC("", "", BigDecimal(10), 0.25);
		
		boolean depositTest2 = depositTester2.deposit(BigDecimal(-10));
		
		assertfalse(depositTest2);
	}
	
	@Test //testing if withdraw returns true
	public void withdrawTest1() {
		Account withdrawTester1 = new GIC("", "", BigDecimal(10), 0.25);
		
		boolean withdrawTest1 = withdrawTester1.withdraw("1");
		
		assertTrue(withdrawTest1);
	}
	
	@Test //testing if withdraw returns false
	public void withdrawTest2() {
		Account withdrawTester2 = new GIC("", "", BigDecimal(10), 0.25);
		
		boolean withdrawTest2 = withdrawTester2.withdraw("100");
		
		assertFalse(withdrawTest2);
	}
	/*
	@Test //tests if arraylist of transations works
	public void arrayListTest() {
		Account arraylistTest = new GIC("", "", BigDecimal(10), 0.25);
		
		arraylistTest.withdraw("1");
		
		String stringTester = "-1"
		String stringTest = arraylistTest.transactions.get(0);
		
		assertFalse(withdrawTest2);
	}*/
}
