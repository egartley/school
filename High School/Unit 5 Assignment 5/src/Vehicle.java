
public class Vehicle extends TaxableItem {

	private double cost;
	private double markup;
	
	public Vehicle(double dealership, double markup, double rate) {
		super(rate);
		cost = dealership;
		this.markup = markup;
	}
	
	public void changeMarkup(double nm) {
		markup = nm;
	}

	@Override
	public double getListPrice() {
		return cost + markup;
	}

}
