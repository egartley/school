public class BabyName {
	private String name;
	private String gender;
	private int quantity;

	public BabyName(String n, String g, int q) {
		name = n;
		gender = g;
		quantity = q;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String toString() {
		return name + ", " + gender + ", " + quantity + "\n";
	}
}
