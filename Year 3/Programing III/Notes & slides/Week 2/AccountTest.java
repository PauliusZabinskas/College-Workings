import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMakeAValidDeposit() {
		Account account;
		try {
			account = new Account(123, 0);
			account.makeDeposit(500.0);
			assertTrue(account.getBalance() == 500.0);
			account.makeDeposit(10.0);
			assertTrue(account.getBalance() == 510.0);
		} catch (NegativeBalanceException e) {
			e.printStackTrace();
		}		
		
	}

	@Test
	void testMakeInvalidDeposit_negativeAmount() {		
		Account account;
		try {
			account = new Account(123, 0);
			double prevBalance = account.getBalance();
			account.makeDeposit(-500.0);
			assertTrue(account.getBalance() == prevBalance);
		} catch (NegativeBalanceException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	void testValidWithdrawal() {
		try {
			Account account = new Account(123, 0);
			account.makeDeposit(50);
			account.makeWithdrawal(10);
			assertTrue(account.getBalance() == 40);
		} catch (NegativeBalanceException e ) {
			e.printStackTrace();
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testInvalidWithdrawal_insufficientFunds() {
		try {
			Account account = new Account(123, 0);
			assertThrows(InsufficientFundsException.class, () -> {
				account.makeWithdrawal(300);
			});
		} catch (NegativeBalanceException e) {
			e.printStackTrace();
		}
	}


}
