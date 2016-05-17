package siit.java.homeworks.bankaccounts;

import java.util.Date;

/**
 * Implementation of a SavingsAccount
 * 
 * @author Daniel Csiki
 *
 */
public class SavingsAccount extends BankAccount {
	/** Interest of account / 1 year */
	private float yearlyInterest;
	/** Commission for each withdrawal from account */
	private float withdrawalComission;

	/**
	 * Constructor for a SavingsAccount
	 * @param accountCreationDate Date when account was created
	 * @param monthlyFee Monthly fee applied to account
	 * @param yearlyInterest Interest of account / 1 year
	 * @param withdrawalComission Commission for each withdrawal from account
	 */
	public SavingsAccount(Date accountCreationDate, float monthlyFee, float yearlyInterest, float withdrawalComission) {
		super(accountCreationDate, monthlyFee);
		this.yearlyInterest = yearlyInterest;
		this.withdrawalComission = withdrawalComission;
	}

	/**
	 * Withdraws money from account balance. It applies withdrawal commission
	 */
	@Override
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		super.withdrawFunds(amount + amount * withdrawalComission / 100);
	}
	/**
	 * Returns balance of account at a given date. Yearly interest is divided for each passing month
	 */
	@Override
	public float getBalance(Date balanceDate) {
		// balance calculated for 1 month
		float balance = super.getBalance(balanceDate);
		return applyInterest(balance);
	}

	/** Applies interest on account balance for each passing month */
	private float applyInterest(float balance) {
		return balance + balance * yearlyInterest / 100 / 12;
	}

}
