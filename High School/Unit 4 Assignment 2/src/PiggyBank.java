public class PiggyBank {

	private int pennies, nickels, dimes, quarters;

	public PiggyBank() {
		pennies = 1;
		nickels = 1;
		dimes = 1;
		quarters = 1;
	}

	public PiggyBank(int p, int n, int d, int q) {
		pennies = p;
		nickels = n;
		dimes = d;
		quarters = q;
	}

	public String getTotalMoney() {
		return String.format("$%.2f", ((pennies * 0.01) + (nickels * 0.05)
				+ (dimes * 0.1) + (quarters * 0.25)));
	}

	public void setPennies(int p) {
		pennies = p;
	}

	public void setNickels(int n) {
		nickels = n;
	}

	public void setDimes(int d) {
		dimes = d;
	}

	public void setQuarters(int q) {
		quarters = q;
	}

	public int getPennies() {
		return pennies;
	}

	public int getNickels() {
		return nickels;
	}

	public int getDimes() {
		return dimes;
	}

	public int getQuarters() {
		return quarters;
	}

	public String toString() {
		return quarters + " quarters, " + dimes + " dimes, " + nickels
				+ " nickels and " + pennies + " pennies";
	}

}
