public class Secretary extends Employee {

	private double salary;
	private int typingSpeed;

	public Secretary(String name, int id, String address, int typingSpeed) {
		super(name, id, address);
		this.typingSpeed = typingSpeed;
	}

	@Override
	public void mailCheck() {
		System.out.print("Mailing a check to " + name + " at " + address
				+ " for $" + String.format("%.2f", computePay()));
	}

	@Override
	public double computePay() {
		if (typingSpeed < 100)
			salary = 25000;
		else if (typingSpeed < 150)
			salary = 28000;
		else if (typingSpeed < 200)
			salary = 30000;
		else
			salary = 35000;
		return salary / 52.0;
	}

}
