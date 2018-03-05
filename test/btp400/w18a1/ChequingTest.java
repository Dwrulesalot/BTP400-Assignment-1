package test.btp400.w18a1;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.finance.Chequing;
import org.junit.Test;

public class ChequingTest {

	@Test
	public void test() {
		//BigDecimal amount = new BigDecimal("200.00");
		Chequing chequing = new Chequing("dude", "dude", "dude", 1000.00);
		chequing.toString();
		//Deposit(amount);
		fail("Not yet implemented");
	}

}
