package siit.java.homeworks.bankaccounts;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class LoanAccountTest {

	@Test
	public void whenCreatingLoan_balanceIsCorrect() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		LoanAccount loanAccount = new LoanAccount(10000, 10, accountCreationTime, 60);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		assertEquals(-11000, loanAccount.getLoanStatus(balanceInterogationTime), 0);

	}

	@Test
	public void whenCreatingLoan_InstallmentLeftToPayIsCorrect() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		LoanAccount loanAccount = new LoanAccount(10000, 10, accountCreationTime, 60);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		assertEquals(60, loanAccount.getInstallmentLeftToPay(balanceInterogationTime), 0);
	}

	@Test
	public void whenDepositingInstallment_BalanceIsCorrect() throws InsufficientFundsException, LoanWasPayedException {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		LoanAccount loanAccount = new LoanAccount(10000, 10, accountCreationTime, 60);
		loanAccount.depositInstallment(200f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		assertEquals(-10800, loanAccount.getLoanStatus(balanceInterogationTime), 0);

	}

	@Test
	public void whenDepositingInstallment_InstallmentLeftToPayIsCorrect()
			throws InsufficientFundsException, LoanWasPayedException {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		LoanAccount loanAccount = new LoanAccount(10000, 10, accountCreationTime, 60);
		loanAccount.depositInstallment(200f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		assertEquals(59, loanAccount.getInstallmentLeftToPay(balanceInterogationTime), 0);

	}

	@Test
	public void whenDepositingInstallment_eachInstallmentLeftToPayValueUpdated()
			throws InsufficientFundsException, LoanWasPayedException {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		LoanAccount loanAccount = new LoanAccount(10000, 10, accountCreationTime, 60);
		loanAccount.depositInstallment(200f);
		assertEquals(183.05, loanAccount.getInstallmentValue(), 0.01);

	}

	@Test(expected = LoanWasPayedException.class)
	public void whenLoandWasPayed_noNewDepositCanBeMade() throws InsufficientFundsException, LoanWasPayedException {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		LoanAccount loanAccount = new LoanAccount(10000, 10, accountCreationTime, 60);
		loanAccount.depositInstallment(11000f);
		loanAccount.depositInstallment(200f);
	}

}
