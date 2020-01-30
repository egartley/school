/**
 * <<< THIS CODE IS COMPLETE >>> This program tests the BankAccount class and
 * its subclasses.
 */
public class BankAccountTester {
	public static void main(String[] args) {
		CheckingAccount joesAccount = new CheckingAccount(1000);
		joesAccount.withdraw(300);
		joesAccount.deposit(500);
		joesAccount.withdraw(100);
		joesAccount.withdraw(200);
		joesAccount.deposit(300);
		joesAccount.deductFees();
		// Balance should be $1196
		System.out.printf("Joe's balance = $%.2f", joesAccount.getBalance());
		SavingsAccount janesAccount = new SavingsAccount(2000, 4.2);
		janesAccount.withdraw(1000);
		// Balance should be $1000
		System.out.printf("\nJanes's balance = $%.2f",
				janesAccount.getBalance());
		janesAccount.withdraw(1000); // withdrawel not allowed
		// Balance should be $1000
		System.out.printf("\nJanes's balance = $%.2f",
				janesAccount.getBalance());
		janesAccount.withdraw(995); // withdrawel not allowed
		// Balance should be $1000
		System.out.printf("\nJanes's balance = $%.2f",
				janesAccount.getBalance());
		janesAccount.addInterest();
		// Balance should be $1042
		System.out.printf("\nJanes's balance = $%.2f",
				janesAccount.getBalance());
		joesAccount.transfer(100, janesAccount);
		// Balance should be $1142
		System.out.printf("\nJanes's balance = $%.2f",
				janesAccount.getBalance());
	}
}