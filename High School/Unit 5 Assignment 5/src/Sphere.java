
public class Sphere implements Sizeable {

	public double radius;
	
	public Sphere(double r) {
		radius = r;
	}
	
	@Override
	public double volume() {
		return (4.0 / 3.0) * (radius * radius * radius) * Math.PI;
	}

}
