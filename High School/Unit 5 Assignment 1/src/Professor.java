public class Professor extends Person {

	public String university;
	public String field;
	public String education;
	public int salary;

	public Professor(String first, String last, int age, int weight,
			int height, String university, String field, String education,
			int salary) {
		super(first, last, age, weight, height);
		this.university = university;
		this.field = field;
		this.education = education;
		this.salary = salary;
	}

	@Override
	public void display() {
		System.out.println(toString() + " makes $" + salary + " per year");
	}

	@Override
	public void talk() {
		System.out.println("I like to teach " + field);
	}

	@Override
	public void eat() {
		System.out.println("I like to eat my students' will to live...");
	}

	public String toString() {
		return "Professor " + super.toString() + " teaches " + field + " at "
				+ university;
	}

}
