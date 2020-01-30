/**
 * <<< THIS CLASS IS NOT COMPLETE >>> A bank account has a balance that can be
 * changed by deposits and withdrawals.
 */
public class BankAccount {
	
	private double balance;

	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount() {
		balance = 0;
	}

	/**
	 * Constructs a bank account with a given balance.
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}

	/**
	 * Deposits money into the bank account.
	 */
	public void deposit(double amount) {
		balance += amount;
	}

	/**
	 * Withdraws money from the bank account.
	 */
	public void withdraw(double amount) {
		balance -= amount;
	}

	/**
	 * Gets the current balance of the bank account.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Transfers money from the bank account to another account
	 */
	public void transfer(double amount, BankAccount other) {
		other.deposit(amount);
		withdraw(amount);
	}
}