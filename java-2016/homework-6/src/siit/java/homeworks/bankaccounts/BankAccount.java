package siit.java.homeworks.bankaccounts;

import java.util.Calendar;
import java.util.Date;

/**
 * Abstract class BankAccount
 * 
 * @author Daniel Csiki
 *
 */
public abstract class BankAccount {
	/** Balance of account */
	protected float balance;
	/** Date when account was created */
	public Date accountCreationDate;
	/** Monthly fee applied on account */
	private float monthlyFee;

	/**
	 * Constructor for BankAccount
	 * 
	 * @param accountCreationDate
	 *            Date when account was created
	 * @param monthlyFee
	 *            Monthly fee applied on account
	 */
	public BankAccount(Date accountCreationDate, float monthlyFee) {
		super();
		this.accountCreationDate = accountCreationDate;
		this.monthlyFee = monthlyFee;
	}

	/** Adds funds into account balance */
	public void addFunds(float amount) {
		balance += amount;
	}

	/**
	 * Withdraws funds from account balance.
	 * <p>
	 * If amount to withdraw is greater than balance, exception is thrown.
	 */
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		if (amount > balance) {
			throw new InsufficientFundsException();
		}
		balance -= amount;
	}

	/**
	 * Returns the ballance of the account and a given date, applying a monthly
	 * fee for each passing month from creation time.
	 */
	public float getBalance(Date balanceDate) {
		return getBalanceWithMonthlyFeesApplied(balanceDate);
	}

	/** Applies monthly fee to balance for each passing month */
	private float getBalanceWithMonthlyFeesApplied(Date balanceDate) {
		// We assume that the account dates are always from the same year to not
		// overcomplicate the number of months
		Calendar accountCreationTime = Calendar.getInstance();
		accountCreationTime.setTime(accountCreationDate);
		// JANUARY is 0
		int accountCreationMonth = accountCreationTime.get(Calendar.MONTH);
		Calendar balanceTime = Calendar.getInstance();
		balanceTime.setTime(balanceDate);
		int currentMonth = balanceTime.get(Calendar.MONTH);
		return balance - monthlyFee * (currentMonth - accountCreationMonth);
	}

}
