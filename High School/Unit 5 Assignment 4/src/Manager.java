public class Manager extends Employee {

	private double salary;
	private int exp;

	public Manager(String name, int id, String address, int yearsOfExperience) {
		super(name, id, address);
		exp = yearsOfExperience;
	}

	@Override
	public void mailCheck() {
		System.out.print("Mailing a check to " + name + " at " + address
				+ " for $" + String.format("%.2f", computePay()));
	}

	@Override
	public double computePay() {
		if (exp <= 5) {
			salary = 50000;
		} else if (exp <= 7) {
			salary = 60000;
		} else {
			salary = 75000;
		}
		return salary / 52.0;
	}

}
