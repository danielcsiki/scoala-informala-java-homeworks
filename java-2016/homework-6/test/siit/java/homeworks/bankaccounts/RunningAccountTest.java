package siit.java.homeworks.bankaccounts;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;


public class RunningAccountTest {

	@Test
	public void whenMonthlyFeeIs0_balanceIsNotModified() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		RunningAccount runningAccount = new RunningAccount(accountCreationTime, 0);
		runningAccount.addFunds(1000);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		assertEquals(1000, runningAccount.getBalance(balanceInterogationTime),0);		
	}
	
	@Test
	public void whenMonthlyFeeIsSet_balanceIsAutomaticallyUpdated(){
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		RunningAccount runningAccount = new RunningAccount(accountCreationTime, 10);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		//monthly fee of 10$, for 4 months = 40$.
		runningAccount.addFunds(1000);
		assertEquals(960, runningAccount.getBalance(balanceInterogationTime),0);
	}
	
	@Test
	public void whenMultipleOperationsAreDone_balanceIsCorrect() throws InsufficientFundsException{
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		RunningAccount runningAccount = new RunningAccount(accountCreationTime, 10);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		runningAccount.addFunds(1000);
		runningAccount.withdrawFunds(500);
		runningAccount.addFunds(200);
		assertEquals(660, runningAccount.getBalance(balanceInterogationTime),0);
		
	}
	
	@Test(expected = InsufficientFundsException.class)
	public void whenNotEnoughFunds_withdrawFails() throws InsufficientFundsException {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		RunningAccount runningAccount = new RunningAccount(accountCreationTime, 5);
		runningAccount.addFunds(1000);
		runningAccount.withdrawFunds(1001);
	}
	
	@Test
	public void whenNotEnoughFunds_andWithdrawCalled_balanceIsCorrect() throws InsufficientFundsException {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		RunningAccount runningAccount = new RunningAccount(accountCreationTime, 5);
		runningAccount.addFunds(1000);
		try {
			runningAccount.withdrawFunds(1001);
			fail("There should have been insufficient funds.");
		} catch (InsufficientFundsException e) {
			// correct - we expected this to be thrown
			// we can now verify whether the balance has not been updated by the
			// withdrawal.
			Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
			assertEquals("4 months worth of fees should have been deducted.", 980,
					runningAccount.getBalance(balanceInterogationTime), 0);
		}
	}

}
