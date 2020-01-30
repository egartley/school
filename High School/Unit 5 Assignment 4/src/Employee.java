
public abstract class Employee {

	public String name, address;
	public int idNumber;
	
	public Employee(String name, int id, String address) {
		this.name = name;
		idNumber = id;
		this.address = address;
	}
	
	public abstract double computePay();
	
	public void mailCheck() {
		System.out.print("Mailing a check to " + name + " at " + address);
	}
	
	public String toString() {
		return name + " (" + idNumber + ") makes $" + String.format("%.2f", computePay()) + " per week";
	}

}
