package siit.java.homeworks.bankaccounts;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;



public class SavingsAccountTest {

	@Test
	public void whenWithdrawalIsMade_withdrawalComissionIsApplied() throws InsufficientFundsException {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingsAccount savingsAccount =  new SavingsAccount(accountCreationTime, 0, 0, .2f);
		savingsAccount.addFunds(1000);
		savingsAccount.withdrawFunds(100);
		Date balanceInterogationTime = TestUtils.getDate(2016, 1, 1);
		assertEquals(899.8 ,savingsAccount.getBalance(balanceInterogationTime),0.001);
		
	}
	
	@Test
	public void monthlyFeesAreApplied(){
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingsAccount savingsAccount = new SavingsAccount(accountCreationTime, 10, 0, .2f);
		savingsAccount.addFunds(1000);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		assertEquals(960,savingsAccount.getBalance(balanceInterogationTime),0);
		
	}
	
	@Test
	public void interestIsApplied(){
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingsAccount savingsAccount = new SavingsAccount(accountCreationTime, 10, 6, .2f);
		savingsAccount.addFunds(1000);
		Date balanceInterogationTime = TestUtils.getDate(2016, 1, 1);
		assertEquals(1005,savingsAccount.getBalance(balanceInterogationTime),0.01);
		
	}
	
	
	
	
	
}
