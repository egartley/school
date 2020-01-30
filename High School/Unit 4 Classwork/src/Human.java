public class Human {

	public static byte MALE = 1, FEMALE = 0;

	private String name;
	private int height, weight;
	private byte age;

	public Human() {
		name = "";
		height = 0;
		weight = 0;
		age = 0;
	}
	
	public Human(String name) {
		this.name = name;
		height = 0;
		weight = 0;
		age = 0;
	}

	public Human(String name, byte age) {
		this.name = name;
		height = 0;
		weight = 0;
		this.age = age;
	}

	public Human(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		age = 0;
	}
	
	public Human(String name, int height, int weight, byte age) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.age = age;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getHeight() {
		return height;
	}
	
	public byte getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}

}