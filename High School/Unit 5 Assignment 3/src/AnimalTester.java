public class AnimalTester {

	public static void main(String[] args) {
		Animal[] a1 = new Animal[]{new Dog("Black Lab", 63), new Dog("Jack Russel", 22), new Cat("Simese", 8)};
		Animal[] a2 = new Animal[]{new Fish("Carp", 3), new Fish("Ocean Sunfish", 2200), new Fish("Bass", 7)};
		AnimalCage zoo1 = new AnimalCage(a1);
		AnimalCage zoo2 = new AnimalCage(a2);
		System.out.println("Zoo 1: " + zoo1);
		System.out.println("Zoo 2: " + zoo2);
		System.out.println("\nHeavier zoo: " + zoo1.compareWeight(zoo2));
	}
	
}
