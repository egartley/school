public class PizzaParlor {

	public int myNumCheesePizzas, myNumPepPizzas, myNumVegPizzas,
			myCheeseSupply, myPepperoniSupply, myVeggieSupply, myRevenue,
			myOrigAcctBal;
	private int myDoughSupply;

	public PizzaParlor() {
		myNumCheesePizzas = 0;
		myNumPepPizzas = 0;
		myNumVegPizzas = 0;
		myCheeseSupply = 400;
		myPepperoniSupply = 200;
		myVeggieSupply = 200;
		myOrigAcctBal = 1000;
		myRevenue = 0;
		myDoughSupply = 400;
	}

	public int getDoughSupply() {
		return myDoughSupply;
	}

	private void pizzaMade() {
		myDoughSupply -= 11;
	}

	public void orderCheese(int n) {
		for (int i = 0; i < n; i++) {
			myNumCheesePizzas++;
			myRevenue += 8;
			myCheeseSupply -= 12;
			pizzaMade();
		}
	}

	public void orderPepperoni(int n) {
		for (int i = 0; i < n; i++) {
			myNumPepPizzas++;
			myRevenue += 10;
			myCheeseSupply -= 8;
			myPepperoniSupply -= 6;
			pizzaMade();
		}
	}

	public void orderVeggie(int n) {
		for (int i = 0; i < n; i++) {
			myNumVegPizzas++;
			myRevenue += 11;
			myCheeseSupply -= 8;
			myVeggieSupply -= 12;
			pizzaMade();
		}
	}

}
