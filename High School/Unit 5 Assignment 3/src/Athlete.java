public abstract class Athlete {

	public String name, team;
	public int height, weight;
	public double salary;

	public Athlete(String name) {
		this(name, 0, 0, 0);
	}

	public Athlete(String name, int height, int weight) {
		this(name, height, weight, 0);
	}

	public Athlete(String name, int height, int weight, double salary) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.salary = salary;
	}

	public Athlete(String name, String team) {
		this(name, 0, 0, 0);
		this.team = team;
	}

	public double heightInFeet() {
		return (height / 12.0) + ((height % 12.0) / 12.0);
	}

	public String toString() {
		return name + ", " + height + " inches tall, weighing " + weight
				+ " lbs";
	}

}
