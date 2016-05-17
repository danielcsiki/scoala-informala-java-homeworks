package siit.java.homeworks.bankaccounts;

import java.util.Date;

public class Main {

	public static void main(String[] args) throws InsufficientFundsException, LoanWasPayedException {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		LoanAccount loanAccount = new LoanAccount(10000, 10, accountCreationTime, 60);
		loanAccount.depositInstallment(200f);
		CreditAccount creditAccount = new CreditAccount(accountCreationTime, 1000f, 0.02f, 0.01f);
		System.out.println("Credit account ballance " + creditAccount.balance);
	}

}
