public class Fish extends Animal {

	public Fish(String type, int weight) {
		super(type, weight);
	}
	
	@Override
	public void move() {
		System.out.println("Swim");
	}

	@Override
	public void eat() {
		System.out.println("Give me fish food!");
	}

	@Override
	public void speak() {
		System.out.println("Bloop!");
	}

}
