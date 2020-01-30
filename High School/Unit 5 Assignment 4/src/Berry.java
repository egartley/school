
public abstract class Berry extends Fruit {

	public Berry() {
		super();
	}
	
	public abstract String getColor();

	@Override
	public double getPricePerPound() {
		return 2.0;
	}

	@Override
	public double getAverageWeight() {
		return 1.0 / 9.0;
	}

	@Override
	public String getName() {
		return "Berry";
	}
	
	@Override
	public String toString() {
		return getName() + " is " + getColor() + ", weighs "
				+ String.format("%.2f", getWeight()) + " pounds and costs $"
				+ String.format("%.2f", getPricePerPound() * getWeight());
	}

}
