public abstract class Fruit {

	private double weight;
	
	public Fruit() {
		weight = (Math.random() * 1.05 + 0.95) * getAverageWeight();
	}

	public double getWeight() {
		return weight;
	}

	public double getPrice() {
		return getWeight() / getPricePerPound();
	}

	public abstract double getPricePerPound();

	public abstract double getAverageWeight();

	public abstract String getName();

	public String toString() {
		return getName() + " weighs " + String.format("%.2f", weight) + " pounds and costs $"
				+ String.format("%.2f", getPricePerPound() * weight);
	}

}
