package siit.java.homeworks.bankaccounts;

import java.util.Date;
/**
 * Implementation of a running account
 * @author Daniel Csiki
 *
 */
public class RunningAccount extends BankAccount {
	
	
	
	/**
	 * Constructor for a running account
	 * @param accountCreationDate Date when account was created
	 * @param monthlyFee Monthly fee of account
	 */
	public RunningAccount(Date accountCreationDate, float monthlyFee) {
		super(accountCreationDate, monthlyFee);
	}
	
	

}
