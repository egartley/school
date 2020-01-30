import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

class UI {

	private static int cbx = 700;
	private static int cby = 400;
	
	private static int rbx = 700;
	private static int rby = 360;
	
	private static int width = 180;
	private static int height = 32;

	private static Color enabledColor = new Color(0, 145, 17);
	private static String cbt = "Calculate";
	private static String rbt = "Reset";
	private static Font font = new Font("Arial", Font.PLAIN, 18);

	static void onClick(int x, int y) {
		if (x >= cbx && x <= cbx + width && y >= cby && y <= cby + height) {
			calculateButtonClicked();
		}
	}

	private static void calculateButtonClicked() {
		ArrayList<Point> points = Field.points;
		Point base = null;

		// get base point
		for (Point p : points) {
			if (p.isBasePoint) {
				base = p;
				break;
			}
		}

		// iterate through all the other points finding the shortest distance
		if (base != null) {
			short index = 0;
			while (index < Field.points.size()) {
				double shortest = Double.MAX_VALUE;
				Point other = null;
				for (Point p : points) {
					if (p.equals(base) || p.isTraveled)
						continue;
					double prev = shortest;
					shortest = Math.min(shortest, Segment.distance(p, base));
					if (prev != shortest)
						other = p;
				}
				if (other != null) {
					Field.segments.add(new Segment(base, other));
					other.isTraveled = true;
				}
				base = other;
				index++;
			}

			Field.isCalculated = true;
		}
	}

	static void render(Graphics graphics) {
		// calculate button
		graphics.setColor(enabledColor);
		graphics.setFont(font);
		
		graphics.fillRect(cbx, cby, width, height);
		graphics.fillRect(rbx, rby, width, height);
		
		graphics.setColor(Color.WHITE);
		graphics.drawString(cbt, cbx + 49, cby + 21);
		graphics.drawString(rbt, rbx + 62, rby + 21);
	}

}