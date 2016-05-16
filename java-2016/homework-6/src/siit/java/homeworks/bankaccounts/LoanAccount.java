package siit.java.homeworks.bankaccounts;

import java.util.Date;

public class LoanAccount extends BankAccount {
	
	private float loanAmount;
	
	public LoanAccount(float loanAmount, Date accountCreationDate, float creditInterest, int installments, Date deadline ) {
		super(accountCreationDate, 0);
		
	}
	
	@Deprecated
	@Override
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		throw new UnsupportedOperationException();
	}

}
