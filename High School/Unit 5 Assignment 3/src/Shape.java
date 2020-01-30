public abstract class Shape {

	public abstract int getPerimeter();

	public abstract int getArea();

	public String toString() {
		return getArea() + ", " + getPerimeter();
	}

}