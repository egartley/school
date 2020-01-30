public class Dog extends Animal {

	public Dog(String type, int weight) {
		super(type, weight);
	}
	
	@Override
	public void move() {
		System.out.println("Throw the ball!");
	}

	@Override
	public void eat() {
		System.out.println("Give me a bone!");
	}

	@Override
	public void speak() {
		System.out.println("Woof!");
	}

}