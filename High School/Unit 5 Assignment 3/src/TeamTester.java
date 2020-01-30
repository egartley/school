public class TeamTester {

	public static void main(String[] args) {
		Team redWings = new Team("Red Wings", new BaseballPlayer[] {
				new BaseballPlayer("Joe Smith", 67, 166),
				new BaseballPlayer("Andrew Dole", 61, 230),
				new BaseballPlayer("Steven Douglas", 55, 156),
				new BaseballPlayer("Kevin Hickory", 58, 211),
				new BaseballPlayer("Paul Landerd", 77, 219),
				new BaseballPlayer("Robert Coulomb", 78, 187),
				new BaseballPlayer("Gregory Sanders", 65, 149),
				new BaseballPlayer("John Kellog", 80, 160) });
		redWings.roster();
		redWings.win();
		redWings.win();
		redWings.win();
		redWings.win();
		redWings.win();
		redWings.win();
		redWings.lose();
		redWings.lose();
		redWings.lose();
		redWings.lose();
		redWings.lose();
		System.out.println(redWings);
	}

}
