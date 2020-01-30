public class ShapeTest {

	public static void main(String[] args) {
		Sizeable[] shapes = new Sizeable[] { new Cube(3.22), new Sphere(33.21), new Sphere(9.13378) };
		printVolume(shapes);
	}

	public static void printVolume(Sizeable[] list) {
		Sizeable largest = list[0];
		for (Sizeable shape : list) {
			if (largest.volume() < shape.volume())
				largest = shape;
		}
		System.out.println(largest.volume());
	}

}
