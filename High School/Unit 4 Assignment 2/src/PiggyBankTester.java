public class PiggyBankTester {
	public static void main(String[] args) {
		// chase contains 4 quarters, 3 dimes, 2 nickels, and 5 pennies.
		PiggyBank chase = new PiggyBank(5, 2, 3, 4);
		// Prints out:
		// 4 quarters, 3 dimes, 2 nickels, and 5 pennies
		System.out.println(chase);
		// Prints out:
		// Your bank currently holds: $1.45
		System.out.println(chase.getTotalMoney());
		// Updates the bank with 4 more quarters and 9 more pennies
		chase.setQuarters(8);
		chase.setPennies(14);
		// Your bank currently holds: $2.54
		System.out.println(chase.getTotalMoney());
		// 8 quarters, 3 dimes, 2 nickels, and 14 pennies
		System.out.println(chase);
	}

}
