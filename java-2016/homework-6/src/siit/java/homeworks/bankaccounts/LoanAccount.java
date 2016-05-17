package siit.java.homeworks.bankaccounts;

import java.util.Date;

public class LoanAccount extends BankAccount {

	public float loanBalance;
	private int installments;
	private float eachInstallmentValue;

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

	private void updateInstallmentValue() {
		eachInstallmentValue = loanBalance / installments * (-1);
	}

	public float getInstallmentValue() {
		return eachInstallmentValue;
	}

	public int getInstallmentLeftToPay(Date balanceDate) {
		return installments;
	}

	public float getLoanStatus(Date balanceDate) {
		return loanBalance;
	}

}
