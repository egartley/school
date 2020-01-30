public class SugarCookie extends Cookie {

	public double extraSugar;

	public SugarCookie(int ovenTemperature) {
		super(ovenTemperature);
		adjustIngredients(24);
	}

	@Override
	public String getRecipe() {
		return super.getRecipe() + " and 1 3/4 cups of additional sugar";
	}

	@Override
	public boolean adjustIngredients(int cookieCount) {
		super.adjustIngredients(cookieCount);
		extraSugar = (cookieCount / 6) * 1.75;
		return true;
	}

}
