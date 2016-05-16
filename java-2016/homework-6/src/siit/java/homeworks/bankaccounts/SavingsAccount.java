package siit.java.homeworks.bankaccounts;

import java.util.Date;





public class SavingsAccount extends BankAccount{
	
	private float yearlyInterest;
	private float withdrawalComission;
	

	public SavingsAccount(Date accountCreationDate, float monthlyFee, float yearlyInterest, float withdrawalComission) {
		super(accountCreationDate, monthlyFee);
		this.yearlyInterest = yearlyInterest;
		this.withdrawalComission = withdrawalComission;
	}
	
			
	@Override
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		super.withdrawFunds(amount + amount * withdrawalComission/100);
	}
	
	@Override
	public float getBalance(Date balanceDate) {
		// balance calculated for 1 month
		float balance = super.getBalance(balanceDate);
		return applyInterest(balance);
	}


	private float applyInterest(float balance) {
		return balance + balance*yearlyInterest/100/12;
	}
	
	
	
	
	
	
	

}
