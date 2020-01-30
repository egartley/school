import java.util.Arrays;

public class AnimalCage {

	private Animal[] animals;

	public AnimalCage(Animal[] animals) {
		this.animals = animals;
	}

	public int totalWeight() {
		int tw = 0;
		for (Animal a : animals) {
			tw += a.getWeight();
		}
		return tw;
	}

	public AnimalCage compareWeight(AnimalCage other) {
		if (other.totalWeight() > this.totalWeight())
			return other;
		return this;
	}
	
	public String toString() {
		return Arrays.toString(animals);
	}

}
