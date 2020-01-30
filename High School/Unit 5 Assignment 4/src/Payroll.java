
public class Payroll {

	private Employee[] workers;
	
	public Payroll(Employee[] employees) {
		workers = employees;
	}
	
	public double weeklyPayroll() {
		double total = 0;
		for (Employee e : workers)
			total += e.computePay();
		return total;
	}

}
