public class Athlete extends Person {

	public String sport;
	public String position;
	public int jerseyNumber;

	public Athlete(String first, String last, int age, int weight, int height,
			String sport, String position, int jerseyNumber) {
		super(first, last, age, weight, height);
		this.sport = sport;
		this.position = position;
		this.jerseyNumber = jerseyNumber;
	}

	@Override
	public void display() {
		System.out.println(toString() + " with number " + jerseyNumber + " on "
				+ position);
	}

	@Override
	public void talk() {
		System.out.println("I like to play " + sport);
	}

	@Override
	public void eat() {
		System.out.println("I like to eat healthy!");
	}

	public String toString() {
		return super.toString() + " plays " + sport;
	}

}
