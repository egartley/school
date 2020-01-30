
public class FruitTester {

	public static void main(String[] args) {
		FruitBasket basket = new FruitBasket();
		basket.add(new GrannySmith());
		basket.add(new McIntosh());
		basket.add(new McIntosh());
		basket.add(new Blueberry());
		basket.add(new Strawberry());
		basket.add(new Blackberry());
		basket.add(new Blackberry());
		System.out.println(basket.toString());
	}

}
