
public class Square extends Shape {

	public int size;
	
	public Square(int length) {
		size = length;
	}
	
	@Override
	public int getPerimeter() {
		return size * 4;
	}

	@Override
	public int getArea() {
		return size * size;
	}

}
