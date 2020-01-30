public class Cat extends Animal {

	public Cat(String type, int weight) {
		super(type, weight);
	}
	
	@Override
	public void move() {
		System.out.println("Walk");
	}

	@Override
	public void eat() {
		System.out.println("Give me cat knip!");
	}

	@Override
	public void speak() {
		switch ((int)(Math.random() * 3 + 1)) {
		case 2:
			System.out.println("Purr!");
			break;
		default:
			System.out.println("Meow!");
			break;
		}
		
	}

}
