public class VehicleTester {

	public static void main(String[] args) {
		double nys = 0.0665;
		
		Vehicle honda = new Vehicle(30000, 3000, nys);
		System.out.println("Honda's list price: $"
				+ String.format("%.2f", honda.getListPrice()));
		System.out.println("Honda's purchase price: $"
				+ String.format("%.2f", honda.purchasePrice()));
		
		Vehicle tesla = new Vehicle(49000, 5000, nys);
		System.out.println("Tesla's list price: $"
				+ String.format("%.2f", tesla.getListPrice()));
		System.out.println("Tesla's purchase price: $"
				+ String.format("%.2f", tesla.purchasePrice()));
	}

}
