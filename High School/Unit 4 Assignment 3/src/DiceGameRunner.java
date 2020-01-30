public class DiceGameRunner {
	
	public static void main(String args[]) {
		int[][] testRolls = { { 3, 4, 5, 5 }, { 4, 4, 5, 6 }, { 2, 2, 1, 4 } };

		DiceGame diceGame = new DiceGame(testRolls);
		System.out.println("Player 0 total dice score: "
				+ diceGame.getPlayerTotal(0));
		System.out.println("Player 1 total dice score: "
				+ diceGame.getPlayerTotal(1));
		System.out.println("Player 2 total dice score: "
				+ diceGame.getPlayerTotal(2));
		System.out.println("Player " + diceGame.getMaxPlayer()
				+ " has the highest score.");
	}
	
}
