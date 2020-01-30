public class DiceGame {

	public int[][] rolls;

	public DiceGame(int[][] rolls) {
		this.rolls = rolls;
	}

	public int getPlayerTotal(int playerNum) {
		int score = rolls[playerNum][0];
		for (int i = 1; i < rolls[playerNum].length; i++) {
			score += rolls[playerNum][i];
		}
		return score;
	}

	public int getMaxPlayer() {
		int maxIndex = 0, prev = getPlayerTotal(0);
		for (int c = 1; c < rolls.length; c++) {
			if (getPlayerTotal(c) > prev)
				maxIndex = c;
		}
		return maxIndex;
	}

}
