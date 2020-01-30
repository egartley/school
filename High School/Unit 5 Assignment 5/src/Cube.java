public class Cube implements Sizeable {

	public double length;
	
	public Cube(double l) {
		length = l;
	}

	@Override
	public double volume() {
		return length * length * length;
	}

}
