public abstract class Animal {

	public String type;
	private int weight;

	public Animal(String type, int weight) {
		this.type = type;
		this.weight = weight;
	}

	public abstract void move();

	public abstract void eat();

	public abstract void speak();

	public int getWeight() {
		return weight;
	}
	
	public String toString() {
		return type + " (" + getWeight() + " lbs)";
	}

}