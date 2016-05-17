package siit.java.homeworks.bankaccounts;

import java.util.Date;

/**
 * Implementation of a LoanAccount
 * @author Daniel Csiki
 *
 */
public class LoanAccount extends BankAccount {
	/** Amount of loan left to be payed back */
	public float loanBalance;
	/** Number if installments left to be payed */
	private int installments;
	/** Value of each installment left to be payed back */
	private float eachInstallmentValue;

	/**
	 * Constructor for a LoanAccount
	 * @param loanAmount The amount of money taken for loan.
	 * @param loanInterestRate Interest of loan (%).
	 * @param accountCreationDate Date of the creation of the loan.
	 * @param installments Number if installments to be payed.
	 */
	public LoanAccount(float loanAmount, float loanInterestRate, Date accountCreationDate, int installments) {
		super(accountCreationDate, 0);
		RunningAccount runningAccount = new RunningAccount(accountCreationDate, 10);
		runningAccount.addFunds(loanAmount);
		loanBalance -= loanAmount + loanAmount * loanInterestRate / 100;
		this.installments = installments;
		this.eachInstallmentValue = loanBalance / installments;

	}

	@Deprecated
	@Override
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Paying an installment. If successful, value of each installment left to be bayed off is recalculated.
	 * @param amount Amount of money deposited to pay off one installment.
	 * @throws InsufficientFundsException thrown when amount of money deposited is lesser than each installment value
	 * @throws LoanWasPayedException thrown when all debt was payed back, including interest.
	 */
	public void depositInstallment(float amount) throws InsufficientFundsException, LoanWasPayedException {
		if (amount < eachInstallmentValue) {
			throw new InsufficientFundsException();
		}
		if (loanBalance >= 0) {
			throw new LoanWasPayedException();
		}
		loanBalance += amount;
		installments -= 1;
		updateInstallmentValue();

	}

	/** Updates the value of each installment that is to be payed. */
	private void updateInstallmentValue() {
		eachInstallmentValue = loanBalance / installments * (-1);
	}
	
	/** Returns the value of each installment that is to be payed. */
	public float getInstallmentValue() {
		return eachInstallmentValue;
	}

	/** Returns the number of each installment that are yet to be payed back */
	public int getInstallmentLeftToPay(Date balanceDate) {
		return installments;
	}

	/** Returns the amount of money needed to be payed back to pay off loan */
	public float getLoanStatus(Date balanceDate) {
		return loanBalance;
	}

}
