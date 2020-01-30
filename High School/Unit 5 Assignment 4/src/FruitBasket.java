public class FruitBasket {

	private final int CAPACITY = 50;
	private final double TAX = 0.08;
	private int fruitCount = 0;
	private Fruit[] list = new Fruit[CAPACITY];

	public boolean add(Fruit fruit) {
		list[fruitCount] = fruit;
		fruitCount++;
		return fruitCount < list.length;
	}

	public int getFruitCount() {
		return list.length;
	}

	public double getSubtotal() {
		double sum = 0;
		for (Fruit f : list) {
			if (f != null)
				sum += f.getPrice();
		}
		return sum;
	}

	public double getTotal() {
		double total = 0;
		for (Fruit f : list) {
			if (f != null)
				total += f.getPrice() * (1 + TAX);
		}
		return total;
	}

	@Override
	public String toString() {
		String r = "";
		for (Fruit f : list) {
			if (f != null)
				r += f.toString() + "\n";
		}
		return r + "Subtotal of $" + String.format("%.2f", getSubtotal())
				+ " and total of $" + String.format("%.2f", getTotal());
	}

}
