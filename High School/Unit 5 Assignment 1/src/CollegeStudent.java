public class CollegeStudent extends Person {

	public String university;
	public String major;
	public int idNumber;
	public int year;

	public CollegeStudent(String first, String last, int age, int weight,
			int height, String university, String major, int idNumber, int year) {
		super(first, last, age, weight, height);
		this.university = university;
		this.major = major;
		this.idNumber = idNumber;
		this.year = year;
	}

	@Override
	public void display() {
		System.out.println(super.toString() + "#" + idNumber);
	}

	@Override
	public void talk() {
		System.out.println("I'm a college student studying " + major);
	}

	@Override
	public void eat() {
		System.out.println("I like to sleep in");
	}

	public String toString() {
		return super.toString() + " attends " + university;
	}

}
