
public class BaseballPlayer extends Athlete {

	public int number;
	
	public BaseballPlayer(String name) {
		super(name);
	}
	
	public BaseballPlayer(String name, int number) {
		super(name, 0, 0, 0);
		this.number = number;
	}

	public BaseballPlayer(String name, int height, int weight) {
		super(name, height, weight);
	}

	public BaseballPlayer(String name, int height, int weight, double salary) {
		super(name, height, weight, salary);
	}

	public BaseballPlayer(String name, String team) {
		super(name, team);
	}
	
	
	
}
