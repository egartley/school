public abstract class TaxableItem implements Item {

	private double taxRate;

	public TaxableItem(double rate) {
		taxRate = rate;
	}

	public abstract double getListPrice();

	@Override
	public double purchasePrice() {
		return getListPrice() * (1.0 + taxRate);
	}

}
