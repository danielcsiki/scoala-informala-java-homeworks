package siit.java.homeworks.bankaccounts;

import java.util.Date;

/**
 * Implementation of a credit account.
 * 
 * @author Daniel Csiki
 *
 */
public class CreditAccount extends BankAccount {
	/** The amount of credit that the account has. */
	private float credit;
	/** Commission for each withdrawal */
	private float withdrawalCommision;
	/** Penalty for exceeding credit limit */
	private float payBackPenalty;

	/**
	 * Constructor for CreditAccount
	 * 
	 * @param accountCreationDate
	 *            Date when account was created
	 * @param credit
	 *            The amount of credit that the account has
	 * @param withdrawalCommision
	 *            Commission for each withdrawal
	 * @param payBackPenalty
	 *            Penalty for exceeding credit limit
	 */
	public CreditAccount(Date accountCreationDate, float credit, float withdrawalCommision, float payBackPenalty) {
		super(accountCreationDate, 0);
		this.credit = credit;
		balance = credit;
		this.withdrawalCommision = withdrawalCommision;
		this.payBackPenalty = payBackPenalty;
	}

	/**
	 * Withdraws amount of funds from account balance.
	 * <p>
	 * If amount to withdraw with commissions applied is greater than balance,
	 * exception is thrown.
	 */
	@Override
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		super.withdrawFunds(amount + amount * withdrawalCommision);
	}

	/**
	 * Returns the balance of the account and a given date, applying a penalty
	 * if credit is greater than balance
	 */
	@Override
	public float getBalance(Date balanceDate) {
		// Ideally we should calculate the credit penalty for each and every
		// month, but for the sake of simplicity we will only compute it once.
		float balance = super.getBalance(balanceDate);
		return applyPenalties(balance);
	}

	/** Applies penalty of credit is greater than the balance */
	private float applyPenalties(float balance) {
		if (credit <= balance) {
			return balance;
		} else {
			return balance - (credit - balance) * payBackPenalty;
		}
	}

}
