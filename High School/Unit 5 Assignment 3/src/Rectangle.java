public class Rectangle extends Shape {

	public int width, height;

	public Rectangle(int w, int h) {
		width = w;
		height = h;
	}

	@Override
	public int getPerimeter() {
		return (2 * width) + (2 * height);
	}

	@Override
	public int getArea() {
		return width * height;
	}

}
