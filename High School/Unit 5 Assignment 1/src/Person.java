public abstract class Person {

	public String firstName;
	public String lastName;
	public int age;
	public int weight;
	public int height;

	public Person() {
		this("John", "Doe", 36, 154, 66);
	}

	public Person(String first, String last) {
		this(first, last, 36, 154, 66);
	}

	public Person(String first, String last, int age, int weight, int height) {
		firstName = first;
		lastName = last;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

	public void talk() {
		System.out.println("Hi, my name is " + firstName + ".");
	}

	public void eat() {
		System.out.println("I like to eat food.");
	}

	public void display() {
		System.out.println(toString());
	}

	public void bodyStats() {
		System.out.println(age + " years old, weighing " + weight + " at "
				+ height + " inches tall");
	}

	public String toString() {
		return firstName + " " + lastName;
	}

}
