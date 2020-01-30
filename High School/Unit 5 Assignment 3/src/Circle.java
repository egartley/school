public class Circle extends Shape {

	public int radius;

	public Circle(int r) {
		radius = r;
	}

	@Override
	public int getPerimeter() {
		return (int) (2 * Math.PI * radius);
	}

	@Override
	public int getArea() {
		return (int) (Math.PI * radius * radius);
	}

}
