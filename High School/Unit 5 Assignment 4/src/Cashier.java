
public class Cashier extends Employee {

	private double hourlyWage, hoursWorked;
	
	public Cashier(String name, int id, String address, int wage, int worked) {
		super(name, id, address);
		hourlyWage = wage;
		hoursWorked = worked;
	}
	
	@Override
	public void mailCheck() {
		System.out.print("Mailing a check to " + name + " at " + address + " with for $" + String.format("%.2f", computePay()));
	}

	@Override
	public double computePay() {
		return hourlyWage * hoursWorked;
	}

}
