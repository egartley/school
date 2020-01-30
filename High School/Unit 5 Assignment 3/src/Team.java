
public class Team {

	public int wins;
	public int losses;
	public double winsToLosses;
	public String name;
	public Athlete[] players;
	
	public Team(String name, Athlete[] players) {
		this.name = name;
		this.players = players;
	}
	
	public void roster() {
		System.out.println("The " + name + " have " + players.length + " players:");
		for (Athlete p : players) {
			System.out.println("• " + p);
		}
	}
	
	public void win() {
		winsToLosses = calcRatio(++wins, losses);
	}
	
	public void lose() {
		winsToLosses = calcRatio(wins, ++losses);
	}
	
	public String toString() {
		return "The " + name + " have won " + wins + " matches, and lost " + losses + ", with a win/lose ratio of " + winsToLosses;
	}
	
	private double calcRatio(int w, int l) {
		if (l == 0)
			return 0;
		return (w * 1.0) / (l * 1.0);
	}

}
