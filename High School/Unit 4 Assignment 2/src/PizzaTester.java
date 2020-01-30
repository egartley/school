
public class PizzaTester {

	public static void main(String[] args) {
		PizzaParlor parlor = new PizzaParlor();
		parlor.orderCheese(3);
		parlor.orderPepperoni(4);
		parlor.orderVeggie(3);
		System.out.println("# of Cheese ordered is " + parlor.myNumCheesePizzas);
		System.out.println("# of Pepperoni ordered is " + parlor.myNumPepPizzas);
		System.out.println("# of Veggie ordered is " + parlor.myNumVegPizzas + "\n");
		System.out.println("Remaining supply of cheese in ounces is: " + parlor.myCheeseSupply);
		System.out.println("Remaining supply of pepperoni in ounces is: " + parlor.myPepperoniSupply);
		System.out.println("Remaining supply of veggie in ounces is: " + parlor.myVeggieSupply);
		System.out.println("Remaining supply of dough in ounces is: " + parlor.getDoughSupply() + "\n");
		System.out.println("Revenue is $" + parlor.myRevenue + ".00");
		System.out.println("Bank balance is now $" + (parlor.myRevenue + parlor.myOrigAcctBal) + ".00");
	}
	
}
