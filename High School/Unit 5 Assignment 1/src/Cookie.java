public class Cookie {

	private int ovenTemperature;

	private int eggs = 2;
	private double flour = 3;
	private double sugar = .5;
	private double milk = 1;
	
	public Cookie(int ovenTemperature) {
		this.ovenTemperature = ovenTemperature;
		adjustIngredients(12);
	}

	public String getIngredients() {
		if (eggs == 1)
			return "1 egg, " + flour + " cup(s) of flour, " + sugar
					+ " cup(s) of sugar, and " + milk + " cup(s) of milk";
		return eggs + " eggs, " + flour + " cup(s) of flour, " + sugar
				+ " cup(s) of sugar, and " + milk + " cup(s) of milk";
	}

	public String getRecipe() {
		return "For six cookies, you will need 1 egg, 1 1/2 cups of flour, 1/4 cups of sugar, and 1/2 cup of milk";
	}

	public String mix(String ingredient1, String ingredient2) {
		return "Mix the " + ingredient1 + " and " + ingredient2 + "together";
	}

	public boolean adjustIngredients(int cookieCount) {
		if (cookieCount < 6)
			return false;
		int c = (cookieCount / 6);
		eggs *= c;
		flour = c * 1.5;
		sugar = c * 0.25;
		milk = c * 0.5;
		return true;
	}

	public String getImage() {
		return "___________\n|         |\n|         |\n|         |\n¯¯¯¯¯¯¯¯¯¯¯";
	}

	public int getCookTime() {
		return ovenTemperature / 9;
	}

	public int getEggs() {
		return eggs;
	}

	public double getFlour() {
		return flour;
	}

	public double getSugar() {
		return sugar;
	}

	public double getMilk() {
		return milk;
	}

}