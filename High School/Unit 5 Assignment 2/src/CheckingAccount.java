public class CheckingAccount extends BankAccount {

	private int transactionCount;

	private static final int FREE_TRANSACTIONS = 3;
	private static final double TRANSACTION_FEE = 2.0;

	public CheckingAccount(double initialBalance) {
		super(initialBalance);
		transactionCount = 0;
	}

	public void deposit(double amount) {
		super.deposit(amount);
		transactionCount++;
	}

	public void withdraw(double amount) {
		super.withdraw(amount);
		transactionCount++;
	}

	public void deductFees() {
		for (int i = 0; i < transactionCount - FREE_TRANSACTIONS; i++) {
			withdraw(TRANSACTION_FEE);
			transactionCount--;
		}
		transactionCount = 0;
	}

}