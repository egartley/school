public class SnickerDoodle extends Cookie {

	public double cinnamon;
	
	public SnickerDoodle(int ovenTemperature) {
		super(ovenTemperature);
		adjustIngredients(6);
	}
	
	@Override
	public String getRecipe() {
		return super.getRecipe() + " and 1/2 cup of cinnamon";
	}
	
	@Override
	public boolean adjustIngredients(int cookieCount) {
		super.adjustIngredients(cookieCount);
		cinnamon = (cookieCount / 6) * 0.5;
		return true;
	}

}
