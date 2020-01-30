public abstract class Apple extends Fruit {

	public Apple() {
		super();
	}

	public abstract String getColor();

	@Override
	public double getPricePerPound() {
		return 1.5;
	}

	@Override
	public double getAverageWeight() {
		return 1.0 / 3.0;
	}

	public String toString() {
		return getName() + " is " + getColor() + ", weighs "
				+ String.format("%.2f", getWeight()) + " pounds and costs $"
				+ String.format("%.2f", getPricePerPound() * getWeight());
	}

	@Override
	public String getName() {
		return "Apple";
	}

}
