package test.btp400.w18a1;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankTest {

	@Test //testing if safe state is properly created
	public void test() {
		
		Bank test = new Bank();
		
		Bank tester = new Bank("Seneca@York");
		
		assertEquals(tester, test);
		
	}
	
	@Test //testing if addAccount returns true
	public void addAccountTest1() {
		
		Bank test = new Bank();
		
		Account addAccountTester1 = new GIC();
		
		boolean addAccountTest1 = test.addAccount(addAccountTester1);
		
		assertTrue(addAccountTest1);
	}
	
	@Test //testing if addAccount returns false
	public void addAccountTest2() {
		
		Bank test = new Bank();
		
		Account addAccountTester2 = null;
		
		boolean addAccountTest2 = test.addAccount(addAccountTester2);
		
		assertFalse(addAccountTest2);
	}
	
	@Test //testing if account is properly removed
	public void removeAccountTest() {
		
		Bank test = new Bank();
		
		Account tester = new GIC();
		
		test.addAccount(tester);
		
		
		assertEquals(tester, test.removeAccount(""));
		
	}
	
	@Test //testing if searchByBalance returns an existing account array
	public void searchByBalanceTest() {
		
		Bank test = new Bank();
		
		Account temp = new GIC("", "", BigDecimal(10), 0, 0);
		
		Account[] tester = new Account [1];
		
		tester[0]= temp;
		
		test.addAccount(temp);
		
		assertEquals(tester, test.searchByBalance("10"));
		
	}
	
	@Test //testing if searchByAccountName returns an existing account array
	public void searchByAccountNameTest() {
		
		Bank test = new Bank();
		
		Account temp = new GIC("a", "", BigDecimal(0), 0, 0);
		
		Account[] tester = new Account [1];
		
		tester[0]= temp;
		
		test.addAccount(temp);
		
		assertEquals(tester, test.searchByAccountName("a"));
		
	}
	
	@Test //testing if searchByAccountNumber returns an existing account
	public void searchByAccountNumberTest() {
		
		Bank test = new Bank();
		
		Account temp = new GIC("", "a", BigDecimal(0), 0, 0);
		
		test.addAccount(temp);
		
		assertEquals(tester, test.searchByAccountName("a"));
		
	}

}
