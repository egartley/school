public class CookieMonster {

	public static void main(String[] args) {
		SnickerDoodle doodle = new SnickerDoodle(375);
		SugarCookie sugar = new SugarCookie(450);
		System.out.println("Cook times:");
		System.out.println(doodle.getCookTime() + " minutes and "
				+ sugar.getCookTime() + " minutes");
		System.out.println("\nAdjust ingredients:");
		System.out.println("(6 cookies) " + doodle.getEggs() + " egg(s), "
				+ doodle.getFlour() + " cup(s) of flour, " + doodle.getSugar()
				+ " cup(s) of sugar, and " + doodle.getMilk()
				+ " cup(s) of milk and " + doodle.cinnamon + " cup(s) of cinnamon");
		System.out.println("(24 cookies) " + sugar.getEggs() + " egg(s), "
				+ sugar.getFlour() + " cup(s) of flour, " + sugar.getSugar()
				+ " cup(s) of sugar, and " + sugar.getMilk()
				+ " cup(s) of milk and " + sugar.extraSugar
				+ " cup(s) of extra sugar");
	}

}