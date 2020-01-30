import java.awt.Color;

public class Pixel {

	private Color color;
	
	public Pixel(Color c) {
		color = c;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String toString() {
		if (color.getAlpha() != 0)
			return "X";
		else
			return "-";
	}
	
}